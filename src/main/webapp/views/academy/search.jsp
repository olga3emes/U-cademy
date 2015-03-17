
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form action="academy/search.do" method="get">
<input id="s" type="text" name="s" class="form-control" placeholder="Search">
 </form>
<%-- SCRIPT CAMPO BUSCADOR --%>
<script type="text/javascript">
document.getElementById("s").onsearch = function() {myFunction()};

function myFunction() {
    var x = document.getElementById("s");
    window.location.href = "academy/search.do?s="+x.value;
}
</script>

<display:table pagesize="5" class="list" keepStatus="true"
	name="academies" requestURI="${requestURI}" id="row">
	
	<!-- Attributes -->

	<spring:message code="academy.name" var="name" />
	<display:column property="name" title="${name}"
		sortable="true" />
		
	<spring:message code="academy.country" var="country" />
	<display:column property="country" title="${country}"
		sortable="true" />
		
	<spring:message code="academy.city" var="city" />
	<display:column property="city" title="${city}"
		sortable="true" />
	
	<spring:message code="academy.address" var="address" />
	<display:column property="address" title="${address}"
		sortable="true" />
	
	<spring:message code="academy.postcode" var="postcode" />
	<display:column property="postcode" title="${postcode}"
		sortable="true" />
		
	<spring:message code="academy.phone" var="phone" />
	<display:column property="phone" title="${phone}"
		sortable="true" />
		
	<spring:message code="academy.maxPrice" var="maxPrice" />
	<display:column property="maxPrice" title="${maxPrice}"
		sortable="true" />
		
	<spring:message code="academy.minPrice" var="minPrice" />
	<display:column property="minPrice" title="${minPrice}"
		sortable="true" />
		
</display:table>