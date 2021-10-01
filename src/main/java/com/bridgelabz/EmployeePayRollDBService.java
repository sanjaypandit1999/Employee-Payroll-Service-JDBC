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
}
