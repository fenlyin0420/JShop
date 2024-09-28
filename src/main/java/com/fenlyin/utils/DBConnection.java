//package com.fenlyin.utils;
//
//import java.sql.*;
//
//public class DBConnection {
//    private static final String driver = "com.mysql.cj.jdbc.Driver";
//    private static final String URL = "jdbc:mysql://localhost:3306/Jshop?allowPublicKeyRetrieval=true&useSSL=false";
//    private static final String USERNAME = "fenlyin";
//    private static final String PASSWORD = "";
//
//    // 静态代码块
//    static {
//        try {
////            Class.forName(driver);
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (NoClassDefFoundError e) {
//            throw new RuntimeException("nima", e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException("MySQL JDBC driver not found in the classpath", e);
//        }
//    }
//
//    public static Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
//    }
//
//    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
//        if(resultSet!=null){
//            try {
//                resultSet.close();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        if(statement!=null){
//            try {
//                statement.close();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        if(connection!=null){
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}
package com.fenlyin.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 工具类：读取数据库属性文件、加载驱动、获取连接、关闭资源
 */
public class DBUtil {
    private static String driver=null;
    private static String url=null;
    private static String user=null;
    private static String password=null;

    private static Connection conn=null;
    static {
        try {
            InputStream in=DBUtil .class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties=new Properties();
            properties.load(in);
//            driver=properties.getProperty("driver");
            driver=properties.getProperty("com.mysql.jdbc.cj.Driver");
            url=properties.getProperty("url");
            user= properties.getProperty("user");
            password=properties.getProperty("password");
            //2、加载驱动
            Class.forName(driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //获取连接
    public static Connection getConnection(){
        //建立连接
        try {
            if(conn==null||conn.isClosed()){
                conn= DriverManager.getConnection(url,user,password);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    //关闭资源
    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
