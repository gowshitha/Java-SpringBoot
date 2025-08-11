# Employee REST API – Java Spring Boot

A simple **Spring Boot RESTful web service** that manages a list of employees.  
This service supports retrieving all employee data via an HTTP `GET` request to:

http://localhost:8080/employees


## 🚀 Features
- Java Spring Boot backend
- REST API returning JSON
- Hardcoded employee list for demo
- Easy to extend for database support

## 📂 Project Structure
src/main/java/com/example/employeeapi/
├── Employee.java
├── Employees.java
├── EmployeeManager.java
├── EmployeeController.java
└── RestServiceApplication.java



## ▶️ Run
```bash
mvn spring-boot:run
📦 Sample Response
json
Copy
{
  "Employees": [
    {
      "employee_id": "E001",
      "first_name": "John",
      "last_name": "Doe",
      "email": "john.doe@example.com",
      "title": "Software Engineer"
    }
  ]
}