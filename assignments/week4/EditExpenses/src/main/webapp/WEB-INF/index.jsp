<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/style.css">
</head>
<body>
	<h1 class="text-primary text-center">Save Travels</h1>
	<div class="container-fluid d-flex flex-row">
		<table class="table table-striped d-flex flex-nowrap">
			<tr>
				<th class="col-xl align-middle">Expense</th>
				<th class="col-xl align-middle">Vendor</th>
				<th class="col-xl align-middle">Amount</th>
				<th class="col-xl align-middle">Actions</th>
			</tr>
			<c:forEach var="save" items= "${travels}">
			<tr>
				<td class="align-middle"><a href="/expense/${save.id}/name"><c:out value="${save.expense}"/></a></td>
				<td class="col-xl align-middle"><c:out value="${save.vendor}"/></td>
				<td class="col-xl align-middle"><c:out value="${save.amount}"/></td>
				<td class="col-xl align-middle d-flex flex-nowrap"><a class="edit d-flex align-items-center" href="/expense/${save.id}/edit">Edit</a>
				<form class="delete h-25 d-inline-block d-flex w-75 p-3 flex-nowrap" action = "/delete/${save.id}" method="POST"><input type="hidden" name="_method" value="delete">
				<input type="submit" class="delete-btn d-flex w-100 p-3 h-25 d-inline-block" name="Delete" value="Delete"></form></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	
	<div class="grid text-center d-flex justify-content-center">
		<form:form method = "post" class="d-flex flex-col justify-content-center flex-wrap justify-content-center" action="/expense/add" modelAttribute="travel">
			<h2 class="text-primary">Add an Expense</h2>
			<form:label path="expense">Expense Name:</form:label>
			<form:errors path="expense"/>
			<form:input type="text" path="expense"/>
			
			<form:label path="vendor">Vendor:</form:label>
			<form:errors path="vendor"/>
			<form:input type="text" path="vendor"/>
			
			<form:label path="amount">Amount:</form:label>
			<form:errors path="amount"/>		
			<form:input type="number" path="amount"/>
			
			<form:label path="description">Description</form:label>
			<form:errors path="description"/>
			<form:textarea path="description"/>
			<button class="p-3 mb-2 bg-primary text-white">Submit</button>
		</form:form>
	</div>
</body>
</html>