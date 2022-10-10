<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Product for Categories</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css" type="text/css">
</head>
<body>
	<div class="d-flex flex-row mb-3 justify-content-between">
		<h1><c:out value="${oneProduct.productName}"/></h1>
		<a href="/dashboard">Home</a>
	</div>
	<h2>Categories</h2>
		<ul>
		<c:forEach var="category" items = "${categories}">
			<li><c:out value ="${category.categoryName}"/></li>
		</c:forEach>
		</ul>
	<form:form action="/add/category/${oneCategory.id}" method="post" modelAttribute="product">
		<label name="categories">Category</label>
		<select name="categories">
			<c:forEach var="category" items = "${categories}">
			<option value="${category.id}"><c:out value="${category.categoryName}"/></option>
			</c:forEach>
		</select>
		<button>Add</button>
	</form:form>
</body>
</html>