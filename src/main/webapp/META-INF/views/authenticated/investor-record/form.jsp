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

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.investorrecord.form.label.name" path="name"/>
	<acme:form-moment code="authenticated.investorrecord.form.label.sector" path="sector"/>
	<acme:form-url code="authenticated.investorrecord.form.label.statement" path="statement"/>
	<acme:form-textarea code="authenticated.investorrecord.form.label.stars" path="stars"/>
	
	<acme:form-return code="authenticated.investorrecord.form.button.return"/>
</acme:form>
