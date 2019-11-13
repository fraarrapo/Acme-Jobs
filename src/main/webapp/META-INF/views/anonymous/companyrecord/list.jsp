<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="anonymous.companyrecord.list.label.name" path="name" width="10%"/>
	<acme:list-column code="anonymous.companyrecord.list.label.sector" path="sector" width="10%"/>
	<acme:list-column code="anonymous.companyrecord.list.label.nameCEO" path="nameCEO" width="10%"/>
</acme:list>