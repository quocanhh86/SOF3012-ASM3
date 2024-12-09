package com.example.anhnqth01267.servlet;

import com.example.anhnqth01267.entity.HoaDonChiTiet;
import com.example.anhnqth01267.entity.SanPham;
import com.example.anhnqth01267.repository.SanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;

@WebServlet(name = "ServletSanPham",
        value = {
        "/san-pham/hien-thi",
        "/san-pham/add",
        "/san-pham/remove",

        })
public class ServletSanPham extends HttpServlet {
    private SanPhamRepository sanPhamRepository = new SanPhamRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/san-pham/hien-thi")){
            request.setAttribute("listProduct", sanPhamRepository.getAll());
            request.setAttribute("listCombobox", sanPhamRepository.getListCombobox());
            request.getRequestDispatcher("/view/hien-thi.jsp").forward(request, response);
        } else {
            Integer id = Integer.parseInt(request.getParameter("id"));
            SanPham sp = sanPhamRepository.getOne(id);
//            HoaDonChiTiet hdct = sanPhamRepository.getOneInvoice(id);
            sanPhamRepository.delete(sp);
            response.sendRedirect("/san-pham/hien-thi");
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            SanPham sp = new SanPham();
            BeanUtils.populate(sp, request.getParameterMap());
            sanPhamRepository.addSanPham(sp);
            response.sendRedirect("/san-pham/hien-thi");
    }
}
