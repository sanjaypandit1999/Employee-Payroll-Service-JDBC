package com.bridgelabz;

public class EmployeePayRoll {
    public static void main(String[] args) {
        EmployeePayRollDBService employeePayRollService = new EmployeePayRollDBService();
        String query = "select * from employee_payroll";
        employeePayRollService.readData(query);
        employeePayRollService.display();
    }
}
