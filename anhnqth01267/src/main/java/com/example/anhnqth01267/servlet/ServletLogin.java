package com.example.anhnqth01267.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletLogin",
        value = {
                "/asm-filter/login",
                "/asm-filter/logout",
        })
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/asm-filter/login")) {
            request.getRequestDispatcher("/view/login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("/asm-filter/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        HttpSession session = request.getSession();
        if (userName.equals("HangNT169") && passWord.equals("123456")) {
            session.setAttribute("username", "HangNT169");
            session.setAttribute("role", "admin");
            response.sendRedirect("/san-pham/hien-thi");
        } else if (userName.equals("TH01267") && passWord.equals("SD19310")) {
            session.setAttribute("username", "TH01267");
            session.setAttribute("role", "student");
            response.sendRedirect("/san-pham/hien-thi");
        } else {
            request.setAttribute("m1", "Thông tin đăng nhập sai");
            request.getRequestDispatcher("/view/login.jsp").forward(request, response);
        }
    }
}

