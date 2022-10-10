<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Category</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css" type="text/css">
</head>
<body>
	<h1>New Category</h1>
	<a href="/">Home</a>
<!-- create a new category -->
	<form:form action="/new/category"  class="d-flex flex-column" method = "post" modelAttribute="category">
		<h2>Create Category</h2>
		<form:label path="categoryName">Category</form:label>
		<form:errors path="categoryName"></form:errors>
		<form:input type="text" path="categoryName"></form:input>
		<button>Submit</button>
	</form:form>
</body>
</html>