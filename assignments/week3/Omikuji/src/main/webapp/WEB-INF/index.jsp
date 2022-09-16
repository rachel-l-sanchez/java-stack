<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send an Omikuji</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/main.css"/>
</head>
<body class="d-flex">
    <form action="/omikuji/form" class="Omikujiform d-flex flex-column position-absolute start-50" method ="POST">
    	<h1>Send an Omikuji</h1>
        <label for="number">Pick any number from 5 to 25</label>
        <input type="number" name="number">
        <label for="city">Enter the name of any city.</label>
        <input type="text" name="city">
        <label for = "person">Enter the name of any real person</label>
        <input type="text" name="person">
        <label for="hobby">Enter professional endeavor or hobby</label>
        <input type="text" name="hobby">
        <label for="thing">Enter any type of living thing</label>
        <input type="text" name="thing">
        <label for="compliment">Say something nice to someone</label>
        <textarea id="compliment" name="compliment" rows="5" cols="2"></textarea>
        <label>Send and show a friend</label>
        <button type = "submit" class="btn btn-primary">Send</button>
    </form>
</body>
</html>