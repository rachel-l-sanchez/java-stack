<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Dojos and Ninjas</title>
</head>
<body>
	<h1><c:out value="${dojoNinja.name}"/> Location Ninjas</h1>
	<table class="d-flex flex-col table table-striped">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th>Dojo Name</th>
		</tr>
		<c:forEach var="dojo" items="${dojo.ninjas}">
			<tr>
				<td><c:out value="${dojo.first_name }"/></td>
				<td><c:out value="${dojo.last_name }"/></td>
				<td><c:out value="${dojo.age}"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>