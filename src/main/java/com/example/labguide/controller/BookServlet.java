package com.example.labguide.controller;

import com.example.labguide.dals.BookDAL;
import com.example.labguide.dals.DB;
import com.example.labguide.model.Book;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

@WebServlet(name = "BookServlet", value = "/list-book")
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDAL bookDAL = new BookDAL();
        int page = 0;
        int recordsPerPage = 5;
        int totalRecords = bookDAL.getTotalRecord();
        String search = request.getParameter("search");
        ArrayList<Book> listBook;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }
        if (search != null && !search.equals("")) {
            try {
                listBook = bookDAL.searchBooks(search);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            listBook = bookDAL.listBook();
            listBook = bookDAL.getBookByOffsetAndPageSize(page, recordsPerPage);
        }
        request.setAttribute("listBook", listBook);
        request.setAttribute("totalPage", Math.ceil((double) totalRecords / recordsPerPage) );
        request.setAttribute("currentPage", page+1);
        request.setAttribute("recordsPerPage", recordsPerPage);
        request.getRequestDispatcher("WEB-INF/view/list.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }
}