package com.example.employeeapi;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    public static Employees getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("E001", "John", "Doe", "john.doe@example.com", "Software Engineer"));
        list.add(new Employee("E002", "Jane", "Smith", "jane.smith@example.com", "QA Analyst"));
        list.add(new Employee("E003", "Alice", "Brown", "alice.brown@example.com", "Product Manager"));
        return new Employees(list);
    }
}