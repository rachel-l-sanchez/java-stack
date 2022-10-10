<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Category</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css" type="text/css">
</head>
<body>
	<div class="d-flex flex-row justify-content-between">
		
		<h1><c:out value="${oneCategory.categoryName}"/></h1>
		<a href="/dashboard">Home</a>
	</div>
	<h2>Products</h2>
		<ul>
		<c:forEach var="product" items = "${products}">
			<li><c:out value ="${product.productName}"/></li>
		</c:forEach>
		</ul>
	<form:form action="/add/product/${oneProduct.id}" class="d-flex flex-column" method="post" modelAttribute="category">
		<label name="products">Product Name</label>
		<select name="products">
			<c:forEach var="product" items = "${products}">
				<option value="${product.id}"><c:out value="${product.productName}"/></option>
			</c:forEach>
		</select>
		<label path="description">Description</label>
		<input type="text" name="description">
		<label name="price">Price</label>
		<input type="number" name="price">
		<button>Add</button>
	</form:form>
</body>
</html>