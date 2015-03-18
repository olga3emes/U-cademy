
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form action="${actionURI}" modelAttribute="academyForm" enctype="multipart/form-data">>

	<form:hidden path="id"/>
	
	<acme:textbox code="academy.name" path="name"/>
	
	<acme:textarea code="academy.description" path="description"/>
	
	<acme:textbox code="academy.country" path="country"/>
	
	<acme:textbox code="academy.city" path="city"/>
	
	<acme:textbox code="academy.address" path="address"/>
	
	<acme:textbox code="academy.postcode" path="postcode"/>
	
	<acme:textbox code="academy.phone" path="phone"/>
	
	<acme:textbox code="academy.phone2" path="phone2"/>
	
	<acme:textbox code="academy.fax" path="fax"/>
	
	<acme:textbox code="academy.email" path="email"/>
	
	<acme:textbox code="academy.minPrice" path="minPrice"/>
	
	<acme:textbox code="academy.maxPrice" path="maxPrice"/>
	
	<acme:textbox code="academy.tags" path="tags"/>
	
	<acme:file code="academy.image" path="multipartFile" />
	
	<br />
	
	<input type="submit" name="save" value='<spring:message code="academy.save"/>'/>
	
	&nbsp;&nbsp;
	
	<%-- REGLAS DE NEGOCIO CON RESPECTO A BORRAR UNA ACADEMIA --%>
	<jstl:if test="${academyForm.id != 0}">
		<input type="submit" name="delete" value='<spring:message code="academy.delete"/>'/>
	</jstl:if>
	
	<acme:cancel url="academy/owner/list.do" code="academy.return"/>
	
</form:form>