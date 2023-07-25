<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%--<%@ taglib prefix="custom" uri="/WEB-INF/tags/implicit.tld" %>--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Roller</title>
</head>
<body>
<h1>Add Roller</h1>
<form action="${pageContext.request.contextPath}/save" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required/><br/>
    <label for="price">Price:</label>
    <input type="number" id="price" name="price" required/><br/>

    <label for="stock">Stock:</label>
    <input type="number" id="stock" name="stock" required/><br/>

    <button type="submit">Add</button>
</form>
</body>
</html>
