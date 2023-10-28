package com.example.filter;

import com.example.servlet.LoginServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        if(((HttpServletRequest) req).getSession().getAttribute("user") == null) {
            HttpServletResponse sendRed = (HttpServletResponse) resp;
            sendRed.sendRedirect("/login.jsp");
        }
        else filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
    }
}