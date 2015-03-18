
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<display:table name="academies" id="academy" pagesize="5" class="displaytag" requestURI="${requestURI}" >

	<spring:message code="academy.name" var="titleName" />
	<display:column property="name" title="${titleName}" sortable="true"/>
	
	<spring:message code="academy.city" var="titleCity" />
	<display:column property="city" title="${titleCity}" sortable="true"/>
	
	<spring:message code="academy.address" var="titleAddress" />
	<display:column property="address" title="${titleAddress}" sortable="true"/>
	
	<spring:message code="academy.email" var="titleEmail" />
	<display:column property="email" title="${titleEmail}" sortable="true"/>
	
	<spring:message code="academy.phone" var="titlePhone" />
	<display:column property="phone" title="${titlePhone}" sortable="true"/>
	
	<spring:message code="academy.tags" var="titleTags" />
	<jstl:forEach var="t" items="academy.tags">
		<display:column title="${titleTags}" sortable="true">
			<jstl:out value="${t}"/>
		</display:column>
	</jstl:forEach>
	
	
</display:table>