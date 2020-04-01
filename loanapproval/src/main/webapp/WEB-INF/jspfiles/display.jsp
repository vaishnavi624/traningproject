<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Participants List</h2>
	<table border="1" width="80%">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Gender</th>
			<th>Address</th>
		</tr>
		<c:forEach var="tab" items="${data}">
		<tr>
		<td>${tab.cname}</td>
		<td>${tab.cemail}</td>
		<td>${tab.gender}</td>
		<td>${tab.caddress}</td>
		</tr>		
		</c:forEach>
	</table>
<br>
<h3> ${msg } </h3>
</body>
</html>