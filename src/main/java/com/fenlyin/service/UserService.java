package com.fenlyin.service;

import com.fenlyin.dao.UserDAO;
import com.fenlyin.entity.User;

public class UserService {
    public static Boolean userLogin(String username, String password) {
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserByUsername(username);
        return user != null && user.getPassword().equals(password);
    }

    public static Boolean userRegister(String username, String password, String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        UserDAO userDAO = new UserDAO();

        return userDAO.insertUser(user);
    }
}
