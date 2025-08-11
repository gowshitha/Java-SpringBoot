package com.example.employeeapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public Employees getEmployees() {
        return EmployeeManager.getAll();
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee created = EmployeeManager.add(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
