package com.example.anhnqth01267.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "FilterASM",
        value = {
            "/san-pham/*",
            "/san-pham/hien-thi"
        })
public class FilterASM implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request; // convert kiểu
        HttpServletResponse resp = (HttpServletResponse) response;// convert kiểu

        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("username");
        String role = (String) session.getAttribute("role");

        if (userName != null) {
            if (role.equals("admin")) {
                chain.doFilter(req, resp);
            } else if (role.equals("student")) {
                String uri = req.getRequestURI();
                if (uri.contains("/san-pham/hien-thi")) {
                    chain.doFilter(req, resp);
                } else {
                    req.getRequestDispatcher("/view/403.jsp").forward(req, resp);
                }
            }
        } else {
            resp.sendRedirect("/asm-filter/login");
        }
    }
}
