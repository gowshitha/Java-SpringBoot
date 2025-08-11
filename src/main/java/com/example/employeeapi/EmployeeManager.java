package com.example.employeeapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeManager {
        private static final List<Employee> store = Collections.synchronizedList(new ArrayList<>());

    static {
        store.add(new Employee("E001", "John", "Doe", "john.doe@example.com", "Software Engineer"));
        store.add(new Employee("E002", "Jane", "Smith", "jane.smith@example.com", "QA Analyst"));
        store.add(new Employee("E003", "Alice", "Brown", "alice.brown@example.com", "Product Manager"));
        store.add(new Employee("E004", "Bob", "Taylor", "bob.taylor@example.com", "DevOps Engineer"));
    }

    public static Employees getAll() {
        return new Employees(store);
    }

    public static Employee add(Employee e) {
        store.add(e);
        return e;
    }
        
}