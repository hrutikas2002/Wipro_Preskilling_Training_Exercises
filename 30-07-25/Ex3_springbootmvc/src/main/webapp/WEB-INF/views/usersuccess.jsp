<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Success</title>
</head>
<body>

    <h1>Registration Successful</h1>
    <p><strong>Name:</strong> ${user.username}</p>
    <p><strong>Email:</strong> ${user.uemail}</p>
    <p><strong>Phone:</strong> ${user.uphone}</p>

</body>
</html>