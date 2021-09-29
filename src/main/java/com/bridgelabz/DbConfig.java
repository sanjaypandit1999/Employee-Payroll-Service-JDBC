package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {
    public Connection getConnect() {
        String DB_URL = "jdbc:mysql://localhost:3306/payroll_service";
        String USER_NAME = "root";
        String PASSWORD = "Sanju@7076";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded!!");
            connection = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
            System.out.println("connection Established!!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
