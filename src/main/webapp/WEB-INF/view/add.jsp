<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 04/07/2023
  Time: 4:13 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<div class="container mx-auto">
    <div class="row justify-content-between mt-3 align-items-center">
        <h1 class="col">Add Book</h1>
        <a href="list-book" class="col-1 btn btn-primary">List</a>
    </div>
    <form action="add" method="post">
        <div class="mb-3">
            <label for="title" class="form-label">Title</label>
            <input type="text" class="form-control" id="title" name="title" placeholder="Input title">
        </div>
        <div class="mb-3">
            <label for="code" class="form-label">Book code</label>
            <input type="text" class="form-control" id="code" name="code" placeholder="Input book code">
        </div>
        <div class="mb-3">
            <label for="image" class="form-label">Image</label>
            <input type="text" class="form-control" id="image" name="image" placeholder="Input URL image">
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Price</label>
            <input type="text" class="form-control" id="price" name="price" placeholder="Input price">
        </div>
        <div>
            <button type="submit" class="btn btn-primary">Add</button>
        </div>
    </form>
</div>
</body>
</html>
