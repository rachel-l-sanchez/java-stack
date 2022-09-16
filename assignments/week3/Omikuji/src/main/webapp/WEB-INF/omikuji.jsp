<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
</head>
<body>
	<main>
		<div class="border border-success rounded-pill p-2 mb-2 d-flex justify-content-center">
			<h2 class="container text-center text-primary fs-5"><c:out value="${message}"/></h2>
		</div>
	</main>
	<a class="d-flex justify-content-center" href="/">Send an Omikuji</a>
</body>
</html>