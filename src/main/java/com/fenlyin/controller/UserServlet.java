package com.fenlyin.controller;

import io.swagger.annotations.Api;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.fenlyin.service.UserService.userLogin;
import static com.fenlyin.service.UserService.userRegister;

@Api(value = "UserServlet")
@WebServlet("/user")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取 http 参数
        String option = request.getParameter("option");
        if (option.equals("login")) {

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // 调用业务逻辑层方法进行登录
            if (userLogin(username, password)){
                response.sendRedirect("view/home.jsp");
            } else {
                response.sendRedirect("index.jsp?error=invalid");
            }
        } else if (option.equals("register")){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");

            // 调用业务逻辑层方法进行注册
            if (userRegister(username, password, email)) {
                response.sendRedirect("view/login.jsp");
            } else {
                response.sendRedirect("index.jsp?error=invalid");
            }

        }
    }
}
