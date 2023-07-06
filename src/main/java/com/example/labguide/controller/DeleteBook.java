package com.example.labguide.controller;

import com.example.labguide.dals.BookDAL;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteBook", value = "/delete")
public class DeleteBook extends HttpServlet {
    protected BookDAL bookDAL = new BookDAL();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        BookDAL bookDAL = new BookDAL();
        bookDAL.deleteBook(id);
        response.sendRedirect("list-book");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}