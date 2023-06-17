package com.example.labguide.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "InsertStudentServlet", value = "/insert-student")
public class InsertStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public InsertStudentServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("studentId");
        String name = request.getParameter("fullname");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String date = request.getParameter("birthday");
        String addr = request.getParameter("address");
        String className = request.getParameter("className");
        String[] favors = request.getParameterValues("favor");
        StringBuilder f = new StringBuilder();
        for (String fv : favors) {
            f.append(fv).append(",");
        }
        f = new StringBuilder(f.substring(0, f.length() - 1)); //bo dau phay cuoi cung


        //mang du lieu di
        request.setAttribute("studentId", id);
        request.setAttribute("fullName", name);
        request.setAttribute("gender", gender);
        request.setAttribute("birthday", date);
        request.setAttribute("address", addr);
        request.setAttribute("className", className);
        request.setAttribute("favor", f.toString());
        request.getRequestDispatcher("/WEB-INF/viewStudent.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
