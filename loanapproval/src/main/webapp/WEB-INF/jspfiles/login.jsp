<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<head>
   <link href='<c:url value="/resources/css/sample2.css"></c:url>' rel="stylesheet">
</head>

	<h2>SIGN IN</h2>
	
	<form:form action="logindata" method="post" modelAttribute="bean">
	
	   Enter name: <form:input path="cemail"/>
		<br />
		<br>
		Password: <form:input path="cpass"/>
		    <br>
            <br>	
		<input type="submit" value="LOGIN">


	</form:form>
	
	<h2>${msg }</h2>
