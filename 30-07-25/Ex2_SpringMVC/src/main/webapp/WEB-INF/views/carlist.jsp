<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Car List</title>
</head>
<body>
    <h2>Available Car Brands</h2>
    <ul>
        <c:forEach var="car" items="${cars}">
            <li>${car}</li>
        </c:forEach>
    </ul>
</body>
</html>