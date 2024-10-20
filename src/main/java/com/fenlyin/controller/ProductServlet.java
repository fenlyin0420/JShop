package com.fenlyin.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

import com.fenlyin.dao.ProductDAO;
import com.fenlyin.entity.Product;

public class ProductServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ProductDAO productDAO = new ProductDAO();
//        List<Product> products = productDAO.getAllProducts();
//        request.setAttribute("products", products);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("products.jsp");
//        dispatcher.forward(request, response);
//    }
}
