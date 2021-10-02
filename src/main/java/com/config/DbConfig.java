package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {
    private static Connection connection = null;
    static {
        String DB_URL = "jdbc:mysql://localhost:3306/payroll_service";
        String USER_NAME = "root";
        String PASSWORD = "Sanju@7076";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getDbConfig(){
        return connection;
    }
}
