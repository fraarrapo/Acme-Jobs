
package acme.features.anonymous.investorrecord;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.investorRecords.InvestorRecord;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/investor-record/")
public class AnonymousInvestorrecordController extends AbstractController<Anonymous, InvestorRecord> {

	@Autowired
	private AnonymousInvestorrecordListService		listService;

	@Autowired
	private AnonymousInvestorrecordShowService		showService;

	@Autowired
	private AnonymousInvestorrecordListTopService	listTopService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addCustomCommand(CustomCommand.LIST_TOP, BasicCommand.LIST, this.listTopService);
	}

}
