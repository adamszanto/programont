<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="custom" uri="/WEB-INF/tags/implicit.tld" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Roller List</title>
</head>
<body>
<custom:HelloTag />
<h1>Roller List</h1>

<a href="${pageContext.request.contextPath}/add">Add New Roller</a>

<table style="border: 1px solid grey;">
    <custom:tableHeader label1="Item name" label2="Price (HUF)" label3="Available (pcs)"></custom:tableHeader>
    <c:forEach var="roller" items="${rollerList}">
        <custom:tableRow
                value1="${roller.name}"
                value2="${roller.price}"
                value3="${roller.stock}">
        </custom:tableRow>
    </c:forEach>
</table>

    <h6>Logged out: ${rollerList.size()}</h6>
</body>
</html>
