<%--
 * header.jsp
 *
 * Copyright (C) 2014 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<div>
	<ul id="jMenu">
		<li onclick="location.href='welcome/index.do'"><img class="logo" src="images/logo.png" alt="U-cademy Co., Inc." /></li>
		<!-- Do not forget the "fNiv" class for the first level links !! -->
		<security:authorize access="hasRole('ADMIN')">
			<li><a class="fNiv"><spring:message	code="master.page.administrator" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="administrator/action-1.do"><spring:message code="master.page.administrator.action.1" /></a></li>
					<li><a href="administrator/action-2.do"><spring:message code="master.page.administrator.action.2" /></a></li>					
				</ul>
			</li>
		</security:authorize>
		
		<security:authorize access="hasRole('CUSTOMER')">
			<li><a class="fNiv"><spring:message	code="master.page.customer" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="customer/action-1.do"><spring:message code="master.page.customer.action.1" /></a></li>
					<li><a href="customer/action-2.do"><spring:message code="master.page.customer.action.2" /></a></li>					
				</ul>
			</li>
		</security:authorize>
		<security:authorize access="isAnonymous()">
			<li><a class="fNiv" href="security/login.do" ><button type="button" class="btn btn-primary btn-sm" ><spring:message code="master.page.login" /></button></a></li>
			<li><a class="fNiv" href="security/login.do" ><button type="button" class="btn btn-warning btn-sm" ><spring:message code="master.page.register" /></button></a>
			<ul>
					<li class="arrow"></li>
					<li><a href="register/owner.do"><spring:message code="master.page.customer.action.1" /></a></li>
					<li><a href="register/student.do"><spring:message code="master.page.customer.action.2" /></a></li>		
					<li><a href="register/professor.do"><spring:message code="master.page.customer.action.2" /></a></li>				
			</ul>
			</li>
			<li><a class="fNiv"><img src="images/menu35.svg"/></a>
				<ul class="rounded">
					<li class="arrow"></li>
					<li><a href="customer/action-1.do"><spring:message code="master.page.customer.action.2" /></a></li>
					<li><a href="customer/action-2.do"><spring:message code="master.page.customer.action.2" /></a></li>							
				</ul>
			</li>
		</security:authorize>
		<security:authorize access="isAuthenticated()">
			<li>
				<a class="fNiv"> 
					<img src="images/menu35.svg"/>
				</a>
				<ul>
					<li class="arrow"></li>
					<li><a href="profile/action-1.do"><spring:message code="master.page.profile.action.1" /></a></li>
					<li><a href="profile/action-2.do"><spring:message code="master.page.profile.action.2" /></a></li>
					<li><a href="profile/action-3.do"><spring:message code="master.page.profile.action.3" /></a></li>					
					<li><a href="j_spring_security_logout"><spring:message code="master.page.logout" /> </a></li>
				</ul>
			</li>
			<li>
			<img src="images/icon-user.png" class="img-circle profileImage"/>
			<div class="caption">
         <p>(<security:authentication property="principal.username" />)</p>
      </div>
			</li>
		</security:authorize>
		<li class="language-inline">
		<div class="language-inline"><a href="?language=en">en</a></div> <div class="language-inline">|</div> <div class="language-inline"><a href="?language=es">es</a></div>
		</li>
		
	</ul>
</div>


<div>
	
</div>

