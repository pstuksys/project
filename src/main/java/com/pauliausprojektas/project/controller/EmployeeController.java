package com.pauliausprojektas.project.controller;

import com.pauliausprojektas.project.model.Employee;
import com.pauliausprojektas.project.repositories.EmployeeRepository;
import com.pauliausprojektas.project.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
         return employeeService.findAllEmployees();
    }

    //need to create form for user registration in templates.
    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
         Employee saveEmployee = employeeService.createEmployee(employee);
         return new ResponseEntity<>(saveEmployee, HttpStatus.OK);
    }
}
