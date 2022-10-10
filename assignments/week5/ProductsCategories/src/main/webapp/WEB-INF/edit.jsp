<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
</head>
<body>
	<form:form action="/update/product/${oneProduct.id}" method = "post" modelAttribute="newProduct">
		<h2>Edit Product</h2>
		<input type="hidden" name = "_method" value="put">
		<form:label path="productName">Product</form:label>
		<form:errors path="productName"></form:errors>
		<form:input type="text" path="productName"/>
		<form:label path="description">Description</form:label>
		<form:errors path="description"></form:errors>
		<form:input type="text" path="description"/>
		<form:label path="price">Price</form:label>
		<form:errors path="price"></form:errors>
		<form:input type="number" path="price"/>
		<button>Submit</button>
	</form:form>
</body>
</html>