<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page isErrorPage="true"%> 
<html>
<head>
<meta charset="UTF-8">
<title>Ninjas</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<style>
	.dojo, div{
		gap: 10px;
		padding: 10px;
	}
</style>
</head>
<body class="d-flex">
	<div class="d-flex flex-column">
		<form:form action="/ninja/create" class = "d-flex flex-column flex-wrap" method = "POST" modelAttribute="ninja">
		<h1>Add Ninja</h1>
		<form:label path="first_name">First Name:</form:label>
		<form:errors path="first_name"></form:errors>
		<form:input type="text" path="first_name"></form:input>
		<form:label path="last_name">Last Name:</form:label>
		<form:errors path="last_name"></form:errors>
		<form:input type="text" path="last_name"></form:input>
		<form:label path="age">Age:</form:label>
		<form:errors path="age"></form:errors>
		<form:input type="number" path="age"></form:input>
		<form:label path="dojo"></form:label>
		<div>
			<form:select class="dojo" path="dojo">
			<c:forEach var="dojo" items = "${dojos}">
				<option class="dojo" value="${dojo.id}"><c:out value="${dojo.name}"/></option>
			</c:forEach>
			</form:select>
			<form:errors path="dojo"></form:errors>
		</div>
		<button>Submit</button>
	</form:form>
	
	</div>

</body>
</html>