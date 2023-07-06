package com.example.labguide.controller;

import com.example.labguide.dals.BookDAL;
import com.example.labguide.model.Book;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EditBook", value = "/edit")
public class EditBook extends HttpServlet {
    protected BookDAL bookDAL = new BookDAL();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookDAL.getBookById(id);
        request.setAttribute("book", book);
        request.getRequestDispatcher("WEB-INF/view/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String code = request.getParameter("code");
        String image = request.getParameter("image");
        double price = Double.parseDouble(request.getParameter("price"));
        Book book = bookDAL.getBookById(id);
        book.setTitle(title);
        book.setCode(code);
        if (image != null && !image.equals("")) {
            book.setImage(image);
        }
        book.setPrice(price);
        bookDAL.editBook(book);
        response.sendRedirect("list-book");
    }
}