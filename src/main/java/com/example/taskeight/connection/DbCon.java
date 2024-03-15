package com.example.taskeight.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/e_commerce";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Eric7713@";
    private static Connection connection = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection =DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
            System.out.println("Connected");
        }
        return connection;
    }
}
