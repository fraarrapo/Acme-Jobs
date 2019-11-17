<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<jstl:if  test="${command == 'show'}" > 
<acme:form  readonly="true">
	<acme:form-textbox code="authenticated.offer.form.label.title" path="title"/>
	<jstl:if test="${command != 'create'}">
		<acme:form-moment 
		code="authenticated.offer.form.label.creationmoment" 
		path="creationmoment"
		readonly="true"/>
	</jstl:if>
		<acme:form-moment code="authenticated.offer.form.label.deadline" path="deadline"/>
	<acme:form-textarea code="authenticated.offer.form.label.text" path="text"/>
	<acme:form-textbox code="authenticated.offer.form.label.moneyMin" path="moneyMin"/>
		<acme:form-textbox code="authenticated.offer.form.label.moneyMax" path="moneyMax"/>
	<acme:form-textbox code="authenticated.offer.form.label.ticker" path="ticker"/>
	<acme:form-return code="authenticated.offer.form.button.return"/>
</acme:form>

</jstl:if>


