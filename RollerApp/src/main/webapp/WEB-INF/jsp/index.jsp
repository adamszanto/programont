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

<table>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Stock</th>
    </tr>
<%--    <c:forEach var="roller" items="${rollerList}">--%>
<%--        <custom:tableRow>--%>
<%--            <jsp:attribute name="label">Name</jsp:attribute>--%>
<%--            <jsp:attribute name="value"><c:out value="${roller.name}" /></jsp:attribute>--%>
<%--        </custom:tableRow>--%>
<%--        <custom:tableRow>--%>
<%--            <jsp:attribute name="label">Price</jsp:attribute>--%>
<%--            <jsp:attribute name="value"><c:out value="${roller.price}" /></jsp:attribute>--%>
<%--        </custom:tableRow>--%>
<%--        <custom:tableRow>--%>
<%--            <jsp:attribute name="label">Stock</jsp:attribute>--%>
<%--            <jsp:attribute name="value"><c:out value="${roller.stock}" /></jsp:attribute>--%>
<%--        </custom:tableRow>--%>
<%--    </c:forEach>--%>
</table>
</body>
</html>
