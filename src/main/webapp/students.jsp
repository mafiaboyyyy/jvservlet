<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/5/2023
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students Management</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
    <div style="height:100%" class="d-flex justify-content-center align-items-center">
        <form action="SaveServlet" method="post" style="width:50%" class="m-4 bg-light p-4">
            <h3>Add New Student</h3>
            <div class="form-group row">
                <label for="id" class="col-sm-2 col-form-label">ID</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control-plaintext bg-white" id="id" name="id" required/>
                </div>
            </div>
            <div class="form-group row">
                <label for="name" class="col-sm-2 col-form-label">Full Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control-plaintext bg-white" id="name" name="full_name" required/>
                </div>
            </div>
            <div class="form-group row">
                <label for="course" class="col-sm-2 col-form-label">Course</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control-plaintext bg-white" id="course" name="course" required/>
                </div>
            </div>
            <div class="form-group row">
                <label for="score" class="col-sm-2 col-form-label">Score</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control-plaintext bg-white" id="score" name="score" required/>
                </div>
            </div>
            <input type="submit" class="btn btn-primary mb-2" value="Save Student"/>
            <a href="ViewServlet" class="btn btn-success mf-2 mb-2">View Students</a>
        </form>
    </div>
<br/>
</body>
</html>
