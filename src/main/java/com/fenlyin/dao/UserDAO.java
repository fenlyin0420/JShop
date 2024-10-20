package com.fenlyin.dao;

import com.fenlyin.entity.User;
import com.fenlyin.utils.DBConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    public User getUserByUsername(String username) {
        //连接数据库进行查询操作
        User user = new User();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //获取连接
            connection = DBConnection.getConnection();

            //4、获取Statement对象
            String sql = "SELECT * FROM users where username=?";
            statement = connection.prepareStatement(sql);

            //5、执行查询操作
            statement.setString(1, username);
            resultSet = statement.executeQuery();

            //6、处理结果，创建用户对象，属性赋值
            if (resultSet.next()) {
                int _id = resultSet.getInt("id");
                String _username = resultSet.getString("username");
                String _password = resultSet.getString("password");
                String _email = resultSet.getString("email");

                user.setId(_id);
                user.setUsername(_username);
                user.setPassword(_password);
                user.setEmail(_email);

                // debug
                System.out.println(">>> searched: "+_username+" "+_password+" "+_email);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            DBConnection.close(connection,statement,resultSet);
        }
        return user;
    }

    public Boolean insertUser(User user) {
        // 连接数据库
        Connection connection = null;
        PreparedStatement statement = null;
        int affectedRows = 0;
        try {
            // 获取连接
            connection = DBConnection.getConnection();

            // 获取Statement对象
            String sql = "Insert into users(username,password,email) values(?,?,?)";
            statement = connection.prepareStatement(sql);

            // 执行操作
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            affectedRows = statement.executeUpdate();
            // debug
            System.out.println(">>> inserted: "+user.getUsername()+" "+user.getPassword()+" "+user.getEmail());
            return affectedRows > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            DBConnection.close(connection,statement, null);
        }
    }
}
