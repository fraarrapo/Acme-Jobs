<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="autheticated.companyrecord.form.label.name" path="name" />
	<acme:form-textbox code="autheticated.companyrecord.form.label.sector" path="sector" />
	<acme:form-textbox code="autheticated.companyrecord.form.label.nameCEO" path="nameCEO" />
	<acme:form-textarea code="autheticated.companyrecord.form.label.description" path="description" />
	<acme:form-url code="autheticated.companyrecord.form.label.website" path="website" />
	<acme:form-textbox code="autheticated.companyrecord.form.label.phone" path="phone" />
	<acme:form-textbox code="autheticated.companyrecord.form.label.email" path="email"/>
	<acme:form-checkbox code="autheticated.companyrecord.form.label.incorporated" path="incorporated" />
	<acme:form-textbox code="autheticated.companyrecord.form.label.rating" path="rating" />
	
	<acme:form-return code="autheticated.companyrecord.form.button.return"/>
</acme:form>