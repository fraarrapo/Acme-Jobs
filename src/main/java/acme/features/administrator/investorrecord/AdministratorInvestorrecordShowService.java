
package acme.features.administrator.investorrecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investorRecords.InvestorRecord;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorInvestorrecordShowService implements AbstractShowService<Administrator, InvestorRecord> {

	@Autowired
	AdministratorInvestorrecordRepository repository;


	@Override
	public boolean authorise(final Request<InvestorRecord> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<InvestorRecord> request, final InvestorRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "name", "sector", "statement", "stars");

	}

	@Override
	public InvestorRecord findOne(final Request<InvestorRecord> request) {
		assert request != null;
		InvestorRecord result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;

	}

}
