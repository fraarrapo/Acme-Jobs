
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
		boolean esAntes = entity.getDeadline().before(date);
		errors.state(request, !esAntes, "deadline", "administrator.challenge.error.deadline");

		boolean rewardBronzeCurrency = entity.getRewardBronze().getCurrency().equals("EUROS");
		errors.state(request, rewardBronzeCurrency, "rewardBronze", "administrator.challenge.error.rewardBronze");

		boolean rewardSilverCurrency = entity.getRewardBronze().getCurrency().equals("EUROS");
		errors.state(request, rewardSilverCurrency, "rewardSilver", "administrator.challenge.error.rewardSilver");

		boolean rewardGoldCurrency = entity.getRewardBronze().getCurrency().equals("EUROS");
		errors.state(request, rewardGoldCurrency, "rewardGold", "administrator.challenge.error.rewardGold");

	}

	@Override
	public void create(final Request<Challenge> request, final Challenge entity) {
		this.repository.save(entity);
	}

}
