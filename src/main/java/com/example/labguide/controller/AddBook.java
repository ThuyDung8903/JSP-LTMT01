package com.example.labguide.controller;

import com.example.labguide.dals.BookDAL;
import com.example.labguide.model.Book;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddBook", value = "/add")
public class AddBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/view/add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String code = request.getParameter("code");
        String image = request.getParameter("image");
        double price = Double.parseDouble(request.getParameter("price"));
        Book book = new Book();
        book.setTitle(title);
        book.setCode(code);
        book.setImage(image);
        book.setPrice(price);
        BookDAL bookDAL = new BookDAL();
        bookDAL.addBook(book);
        response.sendRedirect("list-book");
    }
}