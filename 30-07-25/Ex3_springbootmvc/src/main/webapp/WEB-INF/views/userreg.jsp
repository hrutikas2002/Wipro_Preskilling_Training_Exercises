<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
</head>
<body>

    <h2>User Registration Form</h2>

    <form action="registersubmit" method="post">
        <div>
            Name: <input type="text" name="username" />
        </div>
        <div>
            Email: <input type="email" name="uemail" />
        </div>
        <div>
            Phone: <input type="text" name="uphone" />
        </div>
        <div>
            <button type="submit">Register</button>
        </div>
    </form>

</body>
</html>