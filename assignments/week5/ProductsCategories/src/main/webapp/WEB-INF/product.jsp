<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css" type="text/css">
</head>
<body>
	<div class="d-flex flex-row justify-content-between">
		<h1>New Product</h1>
		<a href="/dashboard">Home</a>
	</div>
<!--  create a product to products and categories app -->
	<form:form action="/new/product" class="d-flex flex-column" method = "post" modelAttribute="newProduct">
		<form:label path="productName">Product</form:label>
		<form:errors path="productName"></form:errors>
		<form:input type="text" path="productName"></form:input>
		<form:label path="description">Description</form:label>
		<form:errors path="description"></form:errors>
		<form:input type="text" path="description"></form:input>
		<form:label path="price">Price</form:label>
		<form:errors path="price"></form:errors>
		<form:input type="number" path="price"></form:input>
		<button>Submit</button>
	</form:form>
</body>
</html>