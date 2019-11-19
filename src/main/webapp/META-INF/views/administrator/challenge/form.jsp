<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="administrator.challenge.form.label.title" path="title"/>
	<acme:form-textarea code="administrator.challenge.form.label.description" path="description"/>
	<acme:form-textarea code="administrator.challenge.form.label.goalsgold" path="goalGold"/>
	<acme:form-textarea code="administrator.challenge.form.label.goalssilver" path="goalSilver"/>
	<acme:form-textarea code="administrator.challenge.form.label.goalsbronze" path="goalBronze"/>
	<acme:form-money code="administrator.challenge.form.label.rewardsgold" path="rewardGold"/>
	<acme:form-money code="administrator.challenge.form.label.rewardssilver" path="rewardSilver"/>
	<acme:form-money code="administrator.challenge.form.label.rewardsbronze" path="rewardBronze"/>
	<acme:form-moment code="administrator.challenge.form.label.deadline" path="deadline"/>
	
	<acme:form-submit test="${command == 'show' }"
	code="administrator.challenge.form.button.update"
	action="/administrator/challenge/update"/>
	<acme:form-submit test="${command == 'show' }"
	code="administrator.challenge.form.button.delete"
	action="/administrator/challenge/delete"/>
	<acme:form-submit test="${command == 'create' }"
	code="administrator.challenge.form.button.create"
	action="/administrator/challenge/create"/>
	<acme:form-submit test="${command == 'update' }"
	code="administrator.challenge.form.button.update"
	action="/administrator/challenge/update"/>
	<acme:form-submit test="${command == 'delete' }"
	code="administrator.challenge.form.button.delete"
	action="/administrator/challenge/delete"/>
	
	<acme:form-return code="administrator.challenge.form.label.return"/>
</acme:form>
