<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/5/2023
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="d-flex justify-content-center align-items-center bg-light" style="height:100%">
    <form action="LoginServlet" method="post" style="width:30%" class="border border-primary p-4 rounded">
        <div class="form-group">
            <label for="username">User Name</label>
            <input type="text" name="name" class="form-control" id="username" placeholder="Enter your name">
        </div>
        <div>
            <label for="password">Password</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="Enter your password">
        </div>
        <div class="text-center mt-3">
            <input type="submit" class="btn btn-primary" value="Login" />
        </div>
    </form>
</div>
</body>
</html>
