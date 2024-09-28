package com.fenlyin.controller;

import com.fenlyin.dao.UserDAO;
import com.fenlyin.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        // 使用JDBC验证用户
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            response.sendRedirect("src/home.jsp");
        } else {
            response.sendRedirect("index.jsp?error=invalid");
        }
    }
}
