package com.bridgelabz;

import java.util.List;

public interface EmploeePayRollInterface {
    List<Employee> readData(String query);
    double updateBasicPay(String query, String name, double basic_Pay);
}
