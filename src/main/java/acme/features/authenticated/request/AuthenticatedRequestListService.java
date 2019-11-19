
package acme.features.authenticated.request;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedRequestListService implements AbstractListService<Authenticated, acme.entities.requests.Request> {

	@Autowired
	AuthenticatedRequestRepository repository;


	@Override
	public boolean authorise(final Request<acme.entities.requests.Request> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<acme.entities.requests.Request> request, final acme.entities.requests.Request entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description");
	}

	@Override
	public Collection<acme.entities.requests.Request> findMany(final Request<acme.entities.requests.Request> request) {
		assert request != null;

		Collection<acme.entities.requests.Request> result;
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		Date ldt = cal.getTime();

		result = this.repository.findManyAll(ldt);

		return result;
	}

}
