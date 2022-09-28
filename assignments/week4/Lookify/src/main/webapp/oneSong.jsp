<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>One Song</title>
</head>
<body>
	<nav>
		<a href="/dashboard">Dashboard</a>
	</nav>
	<table>
		<tr>
			<td>Title</td>
			<td><c:out value="song.title"></c:out></td>
		</tr>
		<tr>
			<td>Artist</td>
			<td><c:out value="song.artist"></c:out></td>
		</tr>
		<tr>
			<td>Rating(1-10)</td>
			<td><c:out value="song.rating"></c:out></td>
		</tr>
	</table>
	<a href="/delete/{song.id}">Delete</a>
</body>
</html>