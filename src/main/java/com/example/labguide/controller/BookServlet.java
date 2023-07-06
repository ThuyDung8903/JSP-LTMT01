package com.example.labguide.controller;

import com.example.labguide.dals.BookDAL;
import com.example.labguide.model.Book;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "BookServlet", value = "/list-book")
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDAL bookDAL = new BookDAL();
        ArrayList<Book> listBook = bookDAL.listBook();
        request.setAttribute("listBook", listBook);
        request.getRequestDispatcher("WEB-INF/view/list.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }
}