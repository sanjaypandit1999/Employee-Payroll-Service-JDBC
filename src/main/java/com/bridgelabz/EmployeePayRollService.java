package com.bridgelabz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeePayRollService {
    public static void main(String[] args) {
        DbConfig dbConfig = new DbConfig();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
           connection = dbConfig.getConnect();
           //MySQL Query
           String CREATE_DATABASE = "CREATE DATABASE payroll_service";
           String CREATE_TABLE = "Create Table employee_payroll (id int NOT NULL AUTO_INCREMENT, name VARCHAR(150) NOT NULL,salary Double NOT NULL,start DATE NOT NULL, PRIMARY KEY (id))";
           String INSERT_DATA = "insert into employee_payroll (name,salary,start) values ('Sanjay',30000,'2021-08-15'),('Aviral',30000,'2021-06-21'),('Prem',40000,'2021-03-22')";
           String FETCH_QUERY = "select * from employee_payroll";
            //Create platform
            preparedStatement = connection.prepareStatement(FETCH_QUERY);
            preparedStatement.executeQuery();
            System.out.println("Query Executed");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                //close connection and prestatement
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
