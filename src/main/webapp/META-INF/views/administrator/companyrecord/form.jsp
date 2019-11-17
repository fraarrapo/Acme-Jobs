<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="administrator.companyrecord.form.label.name" path="name" />
	<acme:form-textbox code="administrator.companyrecord.form.label.sector" path="sector" />
	<acme:form-textbox code="administrator.companyrecord.form.label.nameCEO" path="nameCEO" />
	<acme:form-textarea code="administrator.companyrecord.form.label.description" path="description" />
	<acme:form-url code="administrator.companyrecord.form.label.website" path="website" />
	<acme:form-textbox code="administrator.companyrecord.form.label.phone" path="phone" />
	<acme:form-textbox code="administrator.companyrecord.form.label.email" path="email"/>
	<acme:form-checkbox code="administrator.companyrecord.form.label.incorporated" path="incorporated" />
	<acme:form-textbox code="administrator.companyrecord.form.label.rating" path="rating" />
	
	<acme:form-submit test="${command == 'show'}"
		code="administrator.companyrecord.form.button.update"
		action="/administrator/company-record/update"/>
	<acme:form-submit test="${command == 'show'}"
		code="administrator.companyrecord.form.button.delete"
		action="/administrator/company-record/delete"/>
	<acme:form-submit test="${command == 'create'}"
		code="administrator.companyrecord.form.button.create"
		action="/administrator/company-record/create"/>
	<acme:form-submit test="${command == 'update'}"
		code="administrator.companyrecord.form.button.update"
		action="/administrator/company-record/update"/>
	<acme:form-submit test="${command == 'delete'}"
		code="administrator.companyrecord.form.button.delete"
		action="/administrator/company-record/delete"/>
	<acme:form-return 
		code="administrator.companyrecord.form.button.return"/>
</acme:form>