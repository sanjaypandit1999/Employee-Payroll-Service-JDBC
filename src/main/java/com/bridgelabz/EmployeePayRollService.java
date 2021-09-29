package com.bridgelabz;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeePayRollService {
    public static void main(String[] args) {
        DbConfig dbConfig = new DbConfig();
        Connection connection = null;
        connection = dbConfig.getConnect();

        String CREATE_DATABASE = "CREATE DATABASE payroll_service";
        String CREATE_TABLE = "Create Table employee_payroll (id int NOT NULL AUTO_INCREMENT, name VARCHAR(150) NOT NULL,salary Double NOT NULL,start DATE NOT NULL, PRIMARY KEY (id))";
        try {
            Statement statement = connection.createStatement();
            statement.execute(CREATE_TABLE);
            System.out.println("Query Executed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
