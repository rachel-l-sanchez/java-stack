<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Fruity Loops</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css"/>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container w-50 p-3" style="background-color:purple;">
		<table class="table table-responsive d-flex flex-column justify-content-evenly p-3 mb-2 bg-white w-100 p-3">
			<thead>
				<tr class="row d-flex flex-row" id="tablehead">
					<th class="col table-head d-flex flex-column" scope="col">Product Name</th>
					<th class="col d-flex table-head flex-column" scope="col">Price</th>
				</tr>	
			</thead>
			<c:forEach var="fruits" items="${item}">
			<tr class="d-flex flex-wrap flex-row">
				<th scope="row"></th>
				<td scope="col" class="col w-50 p-3"><c:out value="${fruits.name}"/></td>
				<td scope = "col" class="col w-50 p-3"><c:out value="${fruits.price}"/></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>