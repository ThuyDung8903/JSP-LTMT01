package com.example.labguide.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("admin") && password.equals("123456")) {
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);

            //remember me
            String remember = request.getParameter("remember");
            Cookie cUser;
            Cookie cPass;
            Cookie cRemember;
            if (remember != null && remember.equals("true")) {
                cUser = new Cookie("username", username);
                cPass = new Cookie("password", password);
                cRemember = new Cookie("remember", "true");

            } else {
                cUser = new Cookie("username", "");
                cPass = new Cookie("password", "");
                cRemember = new Cookie("remember", "");
            }
            cUser.setMaxAge(60);
            cPass.setMaxAge(60);
            cRemember.setMaxAge(60);
            response.addCookie(cUser);
            response.addCookie(cPass);
            response.addCookie(cRemember);
            response.sendRedirect("home");
        } else {
            request.setAttribute("error", "Wrong username or password!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
