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
    protected Book book = new Book();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        book = bookDAL.getBookById(id);
        request.setAttribute("book", book);
        request.getRequestDispatcher("WEB-INF/view/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String code = request.getParameter("code");
        String image = request.getParameter("image");
        double price = Double.parseDouble(request.getParameter("price"));
        book.setTitle(title);
        book.setCode(code);
        if (image != null && !image.equals("")) {
            book.setImage(image);
        }
        book.setPrice(price);
        BookDAL bookDAL = new BookDAL();
        bookDAL.editBook(book);
        response.sendRedirect("list-book");
    }
}