package com.fenlyin.utils;

import java.sql.*;

public class DBConnection {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/Jshop?allowPublicKeyRetrieval=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "811324";

    // 静态代码块
    static {
        try {
            Class.forName(driver);
        } catch (NoClassDefFoundError e) {
            throw new RuntimeException("nima", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC driver not found in the classpath", e);
        }
    }

    /**
     * 建立数据库连接
     * @return Connection Object
     * @throws SQLException 数据库异常
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    /**
     * 关闭连接，释放资源
     * @param connection 连接对象
     * @param statement SQL语句对象
     * @param resultSet SQL查询结果
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
