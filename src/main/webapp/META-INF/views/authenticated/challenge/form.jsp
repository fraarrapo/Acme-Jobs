<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.challenge.form.label.title" path="title"/>
	<acme:form-textarea code="authenticated.challenge.form.label.description" path="description"/>
	<acme:form-textarea code="authenticated.challenge.form.label.goalsgold" path="goalGold"/>
	<acme:form-textarea code="authenticated.challenge.form.label.goalssilver" path="goalSilver"/>
	<acme:form-textarea code="authenticated.challenge.form.label.goalsbronze" path="goalBronze"/>
	<acme:form-money code="authenticated.challenge.form.label.rewardsgold" path="rewardGold"/>
	<acme:form-money code="authenticated.challenge.form.label.rewardssilver" path="rewardSilver"/>
	<acme:form-money code="authenticated.challenge.form.label.rewardsbronze" path="rewardBronze"/>
	<acme:form-moment code="authenticated.challenge.form.label.deadline" path="deadline"/>
	
	<acme:form-return code="authenticated.challenge.form.label.return"/>
</acme:form>
