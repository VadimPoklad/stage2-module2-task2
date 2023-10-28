package com.example.servlet;

import com.example.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("user") != null) resp.sendRedirect("/user/hello.jsp");
        else resp.sendRedirect("/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean validate = Users.getInstance()
                .getUsers()
                .contains(req.getParameter("login")) && !req.getParameter("password").equals("");
        if(validate){
            req.getSession().setAttribute("user", req.getParameter("login"));
            resp.sendRedirect("/user/hello.jsp");
        }
        else resp.sendRedirect("/login.jsp");
    }
}
