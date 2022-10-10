<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css" type="text/css">
<title>Login and Registration</title>
</head>
<body class="d-flex">
	<div class="d-flex flex-col">
		<form:form action="/login" class = "login bg-primary d-flex flex-column p-3 text-white" method = "post" modelAttribute="loginUser">
			<h2>Login</h2>
			<form:label class="d-flex flex-col" path = "email">Email:</form:label>
			<form:input type = "text" path="email"></form:input>
			<form:errors path="email"></form:errors>
	 		<form:label type = "password" path = "password">Password:</form:label>
			<form:input type = "password" path="password"></form:input>
			<form:errors path="password"></form:errors>
			<button>Submit</button>
	</form:form>
	</div class="d-flex flex-column">
	
		<form:form action="/register" class = "registration bg-primary p-3 text-white" method = "post" modelAttribute="registerUser">
			<h2>Registration</h2>
			<div>
				<form:label path = "name">Name:</form:label>
				<form:input type = "text" path="name"></form:input>
				<form:errors path="name"></form:errors>
			</div>
			<div>
				<form:label path = "email">Email:</form:label>
				<form:input type = "text" path="email"></form:input>
				<form:errors path="email"></form:errors>
			</div>
			<div>
				<form:label type = "password" path = "password">Password:</form:label>
				<form:input type = "password" path="password"></form:input>
				<form:errors path="password"></form:errors>
			</div>
			<div>
				<form:label type = "password" path = "confirm">Confirm Password:</form:label>
				<form:input type = "password" path="confirm"></form:input>
				<form:errors path="confirm"></form:errors>
			</div>
			<button>Submit</button>
	 		
		</form:form>
	</div>
</body>
</html>