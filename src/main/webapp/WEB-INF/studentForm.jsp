<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 16/06/2023
  Time: 11:38 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student form</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container mx-auto mt-3">
    <form action="insert-student" method="post" class="form-control">
        <h1>Student form</h1>
        <div class="mb-3">
            <label for="studentId" class="form-label">Student ID</label>
            <input type="text" class="form-control" id="studentId" name="studentId">
        </div>
        <div class="mb-3">
            <label for="fullname" class="form-label">Fullname</label>
            <input type="text" class="form-control" id="fullname" name="fullname">
        </div>
        <div class="m-3">
            <label class="form-label">Gender</label>
            <br>
            <input type="radio" id="male" name="gender" value="true" checked>Male
            <input type="radio" id="female" name="gender" value="false">Female
        </div>
        <div class="mb-3">
            <label for="birthday" class="form-label">Birthday</label>
            <input type="date" class="form-control" id="birthday" name="birthday">
        </div>
        <div class="mb-3">
            <label for="address" class="form-label">Address</label>
            <input class="form-control" id="address" name="address">
        </div>
        <div class="mb-3">
            <label for="className" class="form-label">Classroom</label>
            <select name="className" id="className">
                <option value="" disabled>---Choose---</option>
                <option value="LTMT01">LTMT01</option>
                <option value="LTMT02">LTMT02</option>
                <option value="JavaWeb31">JavaWeb31</option>
                <option value="PHPWeb44">PHPWeb44</option>
                <option value="Laravel04">Laravel04</option>
                <option value="MKT001">MKT001</option>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Favourite</label>
            <input type="checkbox" name="favor" value="Swimming"/>Swimming
            <input type="checkbox" name="favor" value="Playing Game"/>Playing Game
            <input type="checkbox" name="favor" value="Driving"/>Driving
            <input type="checkbox" name="favor" value="Cooking"/>Cooking
            <input type="checkbox" name="favor" value="Traveling"/>Traveling
            <input type="checkbox" name="favor" value="Learning"/>Learning
        </div>

        <div>
            <input class="btn btn-primary" type="submit" value="Send"/>
            <input class="btn btn-light" type="reset" value="Clear"/>
        </div>
    </form>
</div>
</body>
</html>
