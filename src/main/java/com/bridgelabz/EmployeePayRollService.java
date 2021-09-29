package com.bridgelabz;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeePayRollService {
    public static void main(String[] args) {
        DbConfig dbConfig = new DbConfig();
        Connection connection = null;
        connection = dbConfig.getConnect();

        String CREAT_DATABASE = "CREATE DATABASE payroll_service";
        try {
            Statement statement = connection.createStatement();
            statement.execute(CREAT_DATABASE);
            System.out.println("Query Executed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
