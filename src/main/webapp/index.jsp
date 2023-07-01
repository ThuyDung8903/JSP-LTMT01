<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 17/06/2023
  Time: 10:26 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container mx-auto">
    <h1>Please login!</h1>
    <h3 class="italic text-danger">${error}</h3>
    <form class="form-control p-4 mx-auto" action="login" method="post">
        <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="Username"
                   required="required"
                   value="${cookie.username.value}">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Password"
                   required="required"
                   value="${cookie.password.value}">
        </div>
        <div class="mb-3">
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="remember"
                       name="remember" value="true" ${cookie.remember.value ? "checked" : "" }>
                <label class="form-check-label" for="remember">
                    Remember me
                </label>
            </div>
        </div>
        <div>
            <input class="btn btn-primary" type="submit" value="Login"/>
            <input class="btn btn-light" type="reset" value="Cancel"/>
        </div>
    </form>
</div>
</body>
</html>
