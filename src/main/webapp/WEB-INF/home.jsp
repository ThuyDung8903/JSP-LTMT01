<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 17/06/2023
  Time: 10:51 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<c:if test="${empty username}">
    <jsp:forward page="index.jsp"></jsp:forward>
</c:if>
<h1>Welcome: ${username}!!!</h1>
<br/>
<a href="logout">Logout</a>
</body>
</html>
