<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>
	<h1 class="text-center">You have visited <c:out value="${server}"/> <c:out value="${currCount}"/> times</h1>
	<div class="d-flex justify-content-evenly">
		<a href="/">Test Another Visit?</a>
		<a href="/reset">Reset Count</a>
		<a href="/plus/Two">Increment by Two</a>
	</div>
</body>
</html>