package com.example.employeeapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @GetMapping("/employees")
    public Employees getEmployees() {
        return EmployeeManager.getAllEmployees();
    }
}