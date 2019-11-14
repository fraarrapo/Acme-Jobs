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

<acme:form>
	<acme:form-textbox code="administrator.announcement.form.label.title" path="title"/>
	<jstl:if test="${command != 'create'}">
	<acme:form-moment code="administrator.announcement.form.label.moment" path="moment" readonly="true"/>
	</jstl:if>
	<acme:form-url code="administrator.announcement.form.label.moreInfo" path="moreInfo"/>
	<acme:form-textarea code="administrator.announcement.form.label.text" path="text"/>
	
	<acme:form-return code="administrator.announcement.form.button.return"/>
	
	<acme:form-submit code="administrator.announcement.form.button.update" 
	action="/administrator/announcement/update"
	test="${command == 'show'}"/>
	
	<acme:form-submit code="administrator.announcement.form.button.delete" 
	action="/administrator/announcement/delete"
	test="${command == 'show'}"/>
	
	<acme:form-submit code="administrator.announcement.form.button.create" 
	action="/administrator/announcement/create"
	test="${command == 'create'}"/>
	
	<acme:form-submit code="administrator.announcement.form.button.update" 
	action="/administrator/announcement/update"
	test="${command == 'update'}"/>
	
	<acme:form-submit code="administrator.announcement.form.button.delete" 
	action="/administrator/announcement/delete"
	test="${command == 'delete'}"/>
</acme:form>
