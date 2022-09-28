<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Songs by Artist</title>
</head>
<body>
	<nav>
		<h3>Songs by Artist:<c:out value="song.artist"/></h3>
		<form:form action="/${artist}" method="post">
			<form:label path="artist"></form:label>
			<form:input path="artist"></form:input>
			<button>SearchArtists</button>
		</form:form>
		<a href="/all/songs">Dashboard</a>
	</nav>
	<table>
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="song" items="${songs}">
				<tr>
					<td><a href="/song/${song.id}"><c:out value="${song.songName}"/></a></td>
					<td><c:out value="${song.rating}"/></td>
					<td><a href="delete">delete</a></td>
				</tr>
			</c:forEach>
	</table>
</body>
</html>