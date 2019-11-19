
package acme.features.administrator.challenges;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenges.Challenge;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorChallengeCreateService implements AbstractCreateService<Administrator, Challenge> {

	@Autowired
	AdministratorChallengeRepository repository;


	@Override
	public boolean authorise(final Request<Challenge> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Challenge> request, final Challenge entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Challenge> request, final Challenge entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description", "goalGold", "goalSilver", "goalBronze", "rewardGold", "rewardSilver", "rewardBronze", "deadline");
	}

	@Override
	public Challenge instantiate(final Request<Challenge> request) {
		Challenge result;

		result = new Challenge();

		return result;
	}

	@Override
	public void validate(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;

		assert entity != null;
		assert errors != null;

		Date date = new Date();
		if (!errors.hasErrors("deadline")) {
			boolean esAntes = entity.getDeadline().before(date);
			errors.state(request, !esAntes, "deadline", "administrator.challenge.error.deadline");
		}

		if (!errors.hasErrors("rewardGold")) {
			boolean rewardGoldCurrency = entity.getRewardGold().getCurrency().equals("EUROS") || entity.getRewardGold().getCurrency().equals("€");
			errors.state(request, rewardGoldCurrency, "rewardGold", "administrator.challenge.error.rewardGold");

			boolean noNegGold = entity.getRewardGold().getAmount() < 0.0;
			errors.state(request, !noNegGold, "rewardGold", "administrator.challenge.error.noNeg");
		}

		if (!errors.hasErrors("rewardSilver")) {
			boolean rewardSilverCurrency = entity.getRewardSilver().getCurrency().equals("EUROS") || entity.getRewardSilver().getCurrency().equals("€");
			errors.state(request, rewardSilverCurrency, "rewardSilver", "administrator.challenge.error.rewardSilver");
			boolean noNegSilver = entity.getRewardSilver().getAmount() < 0.0;
			errors.state(request, !noNegSilver, "rewardSilver", "administrator.challenge.error.noNeg");
		}
		if (!errors.hasErrors("rewardBronze")) {
			boolean rewardBronzeCurrency = entity.getRewardBronze().getCurrency().equals("EUROS") || entity.getRewardBronze().getCurrency().equals("€");
			errors.state(request, rewardBronzeCurrency, "rewardBronze", "administrator.challenge.error.rewardBronze");
			boolean noNegBronze = entity.getRewardBronze().getAmount() < 0.0;
			errors.state(request, !noNegBronze, "rewardBronze", "administrator.challenge.error.noNeg");
		}

		if (!errors.hasErrors("rewardGold") && !errors.hasErrors("rewardSilver") && !errors.hasErrors("rewardBronze")) {
			boolean bronzeMenor = entity.getRewardBronze().getAmount() <= entity.getRewardSilver().getAmount() && entity.getRewardBronze().getAmount() <= entity.getRewardGold().getAmount();
			errors.state(request, bronzeMenor, "rewardBronze", "administrator.challenge.error.bronzeMenor");
		}

		if (!errors.hasErrors("rewardGold") && !errors.hasErrors("rewardSilver")) {
			boolean silverMenor = entity.getRewardSilver().getAmount() <= entity.getRewardGold().getAmount();
			errors.state(request, silverMenor, "rewardSilver", "administrator.challenge.error.silverMenor");
		}

	}

	@Override
	public void create(final Request<Challenge> request, final Challenge entity) {
		this.repository.save(entity);
	}

}
