<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>



<acme:form>
<acme:form-textbox code="administrator.customparams.list.label.spamWords" path="spamWords"/> 
<acme:form-textbox code="administrator.customparams.list.label.spamThreshold" path="spamThreshold"/> 


<acme:form-submit test="${command == 'show'}"
	code="administrator.configuration.form.button.update"
	action="/administrator/custom-params/update"/>
	
	<acme:form-submit test="${command == 'update'}"
	code="administrator.configuration.form.button.update"
	action="/administrator/custom-params/update"/>
	
	<acme:form-return code="administrator.announcement.form.button.return"/>
	</acme:form>