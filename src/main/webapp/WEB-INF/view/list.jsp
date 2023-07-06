<%@ page import="com.example.labguide.model.Book" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 04/07/2023
  Time: 2:32 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>List Books</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<div class="container mx-auto">
    <div class="row justify-content-between mt-3 align-items-center">
        <h1 class="col">List Books</h1>
        <a href="add" class="col-1 btn btn-primary">Create</a>
    </div>
    <table class="table table-hover mt-3">
        <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Code</th>
            <th>Image</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listBook}" var="book">
            <tr>
                <td>${book.getId()}</td>
                <td>${book.getTitle()}</td>
                <td>${book.getCode()}</td>
                <td><img src="${book.getImage()}" width="100px" height="100px" alt="${book.getTitle()}"></td>
                <td>${book.getPrice()}</td>
                <td>
                    <a href="edit?id=${book.getId()}">Edit</a> |
                    <a href="delete?id=${book.getId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
