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
<link rel="stylesheet" href="/style.css">
</head>
<body>
	<div>
		<h1 class="text-primary text-center">Expense Details</h1>
		<a href="/expense">Go back</a>
	</div>
	<table class="table d-flex flex-nowrap">
		<tr class="row">
			<th class="col text-center">Expense Name</th>
			<td class="col"><c:out value="${travels.expense }"/></td>
		</tr>
		<tr>
			<th class="col text-center">Expense Description</th>
			<th class="col text-center"><c:out value="${travels.description}"/></th>
		</tr>
		<tr>
			<th class="col text-center">Expense Vendor</th>
			<th class="col text-center"><c:out value="${travels.vendor}"/></th>
		</tr>
			<tr>
			<th class="col text-center">Expense Amount</th>
			<th class="col text-center"><c:out value="${travels.amount}"/></th>
		</tr>
	</table>
</body>
</html>