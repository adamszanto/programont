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
<h1>Roller List</h1>

<a href="${pageContext.request.contextPath}/add">Add New Roller</a>
<custom:HelloTag />


    <c:forEach var="roller" items="${rollerList}">
        <custom:tableRow
                label1="Item name"
                value1="${roller.name}"
                label2="Price" value2="${roller.price}"
                label3="On stock"
                value3="${roller.stock}">
        </custom:tableRow>
    </c:forEach>

    <h6>Logged out: ${rollerList.size()}</h6>
</body>
</html>
