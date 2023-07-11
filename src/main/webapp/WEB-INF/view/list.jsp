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
    <div class="row justify-content-between mt-3 align-items-center gap-2">
        <h1 class="col">List Books</h1>
        <a href="add" class="col-1 btn btn-primary">Create</a>
        <a href="logout" class="col-1 btn btn-secondary">Logout</a>
        <form action="list-book" method="get">
            <label>
                <input type="text" name="search" id="search" placeholder="Search">
            </label>
            <input type="submit" value="Search" class="btn btn-primary">
        </form>
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
    <div>
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <c:if test="${currentPage > 1}">
                    <li class="page-item">
                        <a class="page-link" href="list-book?page=${currentPage-1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:forEach begin="1" end="${totalPage}" var="i">
                    <li class="page-item"><a class="page-link" href="list-book?page=${i}">${i}</a></li>
                </c:forEach>
                <c:if test="${currentPage < totalPage}">
                    <li class="page-item">
                        <a class="page-link" href="list-book?page=${currentPage+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
