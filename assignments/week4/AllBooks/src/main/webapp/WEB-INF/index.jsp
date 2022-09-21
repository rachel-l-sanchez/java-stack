<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/style.css">
</head>
<body>
	<table class="table table-striped d-flex flex-column justify-content-center">
		<thead>
			<tr class="row flex-row">
				<th class="col">Id</th>
				<th class="col">Title</th>
				<th class="col">Language</th>
				<th class="col"># Pages</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var = "book" items="${books}">
		<tr class="row flex-row">
			<td class="col"><c:out value="${book.id}"/></td>
			<td class="col"><c:out value="${book.title}"/></td>
			<td class="col"><c:out value="${book.language}"/></td>
			<td class="col"><c:out value="${book.numberOfPages}"/></td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>