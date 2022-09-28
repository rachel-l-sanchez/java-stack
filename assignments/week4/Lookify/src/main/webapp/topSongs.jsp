<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Top Ten</title>
</head>
<body>
	<nav>
		<h2>Top ten Songs:</h2>
		<a href="/all/songs">Dashboard</a>
	</nav>
	<main>
		<div>
			<c:forEach var="song" items="${songs}">
				<p><c:out value="${song.rating}"/></p>
				<p><c:out value="${song.songName}"/></p>
				<p><c:out value="${song.artist}"/></p>
			</c:forEach>
		</div>
	</main>
</body>
</html>