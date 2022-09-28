<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Song</title>
</head>
<body>
	<nav>
		<a href="/look/all">Dashboard</a>
	</nav>
	<main>
		<form:form action="/create/song" method="post" modelAttribute="${song}">
			<form:label path="title"></form:label>
			<form:input type="text" path="title"></form:input>
			<form:label path="artist"></form:label>
			<form:input type="text" path="artist"></form:input>
			<form:label path="rating"></form:label>
			<form:select path="rating">
				<c:forEach var="i" items="${rating}">
					<form:option value="${rating}">${i}</form:option>
				</c:forEach>
			</form:select>
		</form:form>
	</main>
</body>
</html>