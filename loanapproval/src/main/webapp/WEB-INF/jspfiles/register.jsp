<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<html>
<head>
   <link href="<c:url value="/resources/css/sample.css"></c:url>" rel="stylesheet">

</head>
<body>
<h1>Event Selection Page</h1>
<br>
<form:form action="save" method="post" modelAttribute="bean">
Enter Name: <form:input path="cname" /><br/><br/>
Enter Email: <form:input path="cemail" type="email"/>
<br /><br/>
Enter Password: <form:input path="cpass" type="password" />
<br /><br/>
Select Gender: <form:radiobutton path="gender" value="Male" />Male&nbsp;
<form:radiobutton path="gender" value="Female" />Female&nbsp;<br /><br/>
EventType:<form:select path="ceventtype">
<form:option value=""> -- select an option -- </form:option>
<form:option value="Parties">Parties</form:option>
<form:option value="Birthday event">Birthday event</form:option>
<form:option value="Treks event">Treks event</form:option>
<form:option value="Marathons event">Marathons event</form:option>
</form:select>
<br /><br/>
Address: <form:input path="caddress" type="text"/>
 <br/><br/>
 <input type="submit" value="Save It.">
 </form:form>
 <br>
 <h2>${msg }</h2>
</body>
</html>
