<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 17/06/2023
  Time: 9:11 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.0/css/bootstrap.min.css">
    <title>View Data of Student</title>
</head>

<body>
<div class="container mx-auto">
    <h1>View Data of Student</h1>
    <table class="table">
        <tr>
            <td>Student Id:</td>
            <td>${studentId}</td>
        </tr>
        <tr>
            <td>Full name:</td>
            <td>${fullName}</td>
        </tr>
        <tr>
            <td>Gender:</td>
            <td>${gender ? "Male" : "Female"}</td>
        </tr>
        <tr>
            <td>Birthday:</td>
            <td>${birthday}</td>
        </tr>
        <tr>
            <td>Address:</td>
            <td>${address}</td>
        </tr>
        <tr>
            <td>Class name:</td>
            <td>${className}</td>
        </tr>
        <tr>
            <td>Favorites:</td>
            <td>${favor}</td>
        </tr>
    </table>
    <a href="studentForm.jsp" class="btn btn-primary">Back</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
