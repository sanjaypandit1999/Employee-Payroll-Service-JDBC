package com.bridgelabz;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.config.DbConfig.getDbConfig;

public class EmployeePayRollDBService implements EmploeePayRollInterface{
        List<Employee> empList;
        PreparedStatement preparedStatement;
        Connection connection = getDbConfig();
    public List<Employee> readData(String query) {
        empList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();

                employee.setId(resultSet.getInt("Id"));
                employee.setName(resultSet.getString("name"));
                employee.setPhonenumber(resultSet.getString("phone_number"));
                employee.setAddress(resultSet.getString("address"));
                employee.setDepartment(resultSet.getString("department"));
                employee.setStart(resultSet.getString("start"));
                employee.setBasicPay(resultSet.getDouble("basic_Pay"));
                employee.setGender(resultSet.getString("gender"));
                employee.setDeductions(resultSet.getDouble("Deduction"));
                employee.setTaxablePay(resultSet.getDouble("TaxablePay"));
                employee.setIncomeTax(resultSet.getDouble("IncomeTax"));
                employee.setNetPay(resultSet.getDouble("NetPay"));

                empList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empList;
    }

    public void display() {
        for (Employee i : empList) {
            System.out.println(i.toString());
        }
    }

    public double updateBasicPay(String query, String name, double basic_Pay) {
        int row = 0;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, basic_Pay);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
            System.out.println("update successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "SELECT * FROM employee_payroll";
        readData(sql);
        for (Employee employee : empList) {
            if (employee.getName().equals(name)) {
                return employee.getBasicPay();
            }
        }
        return 0.0;
    }

    public List<Employee> retrieveEmployeeByGivenDataRange(String startDate, String endDate) {
        empList = new ArrayList<>();
        String SELECT_QUERY = "select * from employee_payroll where START between ? AND ?";
        String start = String.valueOf(startDate);
        String end = String.valueOf(endDate);
        try {
            preparedStatement = connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setString(1, start);
            preparedStatement.setString(2, end);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();

                employee.setId(resultSet.getInt("Id"));
                employee.setName(resultSet.getString("name"));
                employee.setPhonenumber(resultSet.getString("phone_number"));
                employee.setAddress(resultSet.getString("address"));
                employee.setDepartment(resultSet.getString("department"));
                employee.setStart(resultSet.getString("start"));
                employee.setBasicPay(resultSet.getDouble("basic_Pay"));
                employee.setGender(resultSet.getString("gender"));
                employee.setDeductions(resultSet.getDouble("Deduction"));
                employee.setTaxablePay(resultSet.getDouble("TaxablePay"));
                employee.setIncomeTax(resultSet.getDouble("IncomeTax"));
                employee.setNetPay(resultSet.getDouble("NetPay"));
                empList.add(employee);
            }
            System.out.println("QUERY EXECUTED");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return empList;
    }
}
