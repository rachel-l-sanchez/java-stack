<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Songs</title>
</head>
<body>
	<nav>
		<a href="/create/song">Add New</a>
		<a href="/all/songs">Top Songs</a>
		<form:form action="/${artist}" method="post">
			<form:label path="artist"></form:label>
			<form:input path="artist"></form:input>
			<button>SearchArtists</button>
		</form:form>
	</nav>
	<main>
		<table>
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="song" items="${songs}">
				<tr>
					<td><a href="/one/%{song.id}/song"><c:out value="${song.songName}"/></a></td>
					<td><c:out value="${song.rating}"/></td>
					<td><a href="/delete/${song.id}">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</main>
</body>
</html>