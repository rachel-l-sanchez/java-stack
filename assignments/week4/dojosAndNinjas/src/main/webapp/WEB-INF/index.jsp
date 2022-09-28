<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojos</title>
</head>
<body>
	<form:form action="/dojo/create" class = "d-flex flex-col text-white bg-primary" method = "POST" modelAttribute="dojo">
		<h1>Add Dojo</h1>
		<form:label path="name">Dojo Name:</form:label>
		<form:errors path="name"></form:errors>
		<form:input type="text" path="name"></form:input>
		<div>
		<button>Submit</button>
		</div>
	</form:form>
</body>
</html>