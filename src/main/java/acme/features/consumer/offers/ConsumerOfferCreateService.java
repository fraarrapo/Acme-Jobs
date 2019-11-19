
package acme.features.consumer.offers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.offers.Offer;
import acme.entities.roles.Consumer;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class ConsumerOfferCreateService implements AbstractCreateService<Consumer, Offer> {

	@Autowired
	ConsumerOfferRepository repository;


	@Override
	public boolean authorise(final Request<Offer> request) {

		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Offer> request, final Offer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creationmoment");

	}

	@Override
	public void unbind(final Request<Offer> request, final Offer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "text", "moneyMin.amount", "moneyMax.amount", "moneyMax.currency", "moneyMin.currency", "ticker");

		if (request.isMethod(HttpMethod.GET)) {
			model.setAttribute("aceptar", "false");
		} else {
			request.transfer(model, "aceptar");
		}

	}

	@Override
	public Offer instantiate(final Request<Offer> request) {
		Date t = new Date(System.currentTimeMillis() - 1);
		Offer result;

		result = new Offer();
		result.setCreationmoment(t);

		return result;
	}

	@Override
	public void validate(final Request<Offer> request, final Offer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Date date = new Date();

		if (!errors.hasErrors("deadline")) {
			boolean esAntes = entity.getDeadline().before(date);
			errors.state(request, !esAntes, "deadline", "consumer.offer.error.deadline");
		}
		if (!errors.hasErrors("moneyMin")) {
			boolean moneyCurrencyMin = entity.getMoneyMin().getCurrency().equals("EUROS") || entity.getMoneyMin().getCurrency().equals("€");
			errors.state(request, moneyCurrencyMin, "moneyMin", "consumer.offer.error.moneyMin.currency");
			boolean noNegMin = entity.getMoneyMin().getAmount() < 0.0;
			errors.state(request, !noNegMin, "moneyMin", "consumer.offer.error.moneyMin.noNegMin");
		}
		if (!errors.hasErrors("moneyMax")) {
			boolean moneyCurrencyMax = entity.getMoneyMax().getCurrency().equals("EUROS") || entity.getMoneyMax().getCurrency().equals("€");
			errors.state(request, moneyCurrencyMax, "moneyMax", "consumer.offer.error.moneyMax.currency");
			boolean noNegMax = entity.getMoneyMax().getAmount() < 0.0;
			errors.state(request, !noNegMax, "moneyMax", "consumer.offer.error.moneyMax.noNegMax");
		}

		if (!errors.hasErrors("moneyMin") && !errors.hasErrors("moneyMax")) {
			boolean moneyAmount = entity.getMoneyMin().getAmount() <= entity.getMoneyMax().getAmount();
			errors.state(request, moneyAmount, "moneyMin", "consumer.offer.error.moneyMin");
		}

		boolean repetido = this.repository.getTickers(entity.getTicker()) > 0;
		errors.state(request, !repetido, "ticker", "consumer.offer.error.ticker");

		boolean isAccepted = request.getModel().getBoolean("aceptar");
		errors.state(request, isAccepted, "aceptar", "consumer.offer.error.aceptar");

	}

	@Override
	public void create(final Request<Offer> request, final Offer entity) {
		Date moment;

		moment = new Date(System.currentTimeMillis() - 100);
		entity.setCreationmoment(moment);
		this.repository.save(entity);

	}

}
