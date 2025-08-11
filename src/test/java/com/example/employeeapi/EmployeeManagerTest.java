package com.example.employeeapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeManagerTest {

    @Test
    void addEmployee_increasesListSizeAndPersistsData() {
        int before = EmployeeManager.getAll().getEmployees().size();
        Employee e = new Employee("E777", "Gowshitha", "Reddy", "gow@example.com", "Software Engineer");

        Employee created = EmployeeManager.add(e);

        int after = EmployeeManager.getAll().getEmployees().size();
        Assertions.assertEquals(before + 1, after, "Adding should increase list size by 1");
        Assertions.assertEquals("E777", created.getEmployee_id());
        Assertions.assertEquals("Gowshitha", created.getFirst_name());
        Assertions.assertEquals("Reddy", created.getLast_name());
        Assertions.assertEquals("gow@example.com", created.getEmail());
        Assertions.assertEquals("Software Engineer", created.getTitle());
    }
}
