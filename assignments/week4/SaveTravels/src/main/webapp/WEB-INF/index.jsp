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
	<h1 class="text-primary text-center">Save Travels</h1>
	<table class="table table-striped d-flex">
		<tr class="row">
			<th class="col text-center">Expense</th>
			<th class="col text-center">Vendor</th>
			<th class="col text-center">Amount</th>
		</tr>
		<c:forEach var="save" items= "${travels}">
		<tr class="row">
			<td class="col"><c:out value="${save.expense}"/></td>
			<td class="col"><c:out value="${save.vendor}"/></td>
			<td class="col"><c:out value="${save.amount}"/></td>
		</tr>
		</c:forEach>
	</table>
	<div class="grid text-center d-flex justify-content-center">
		<form:form method = "post" class="d-flex flex-col justify-content-center flex-wrap justify-content-center" action="/travel/add" modelAttribute="travel">
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