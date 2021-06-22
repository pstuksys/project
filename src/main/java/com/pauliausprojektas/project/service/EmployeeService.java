package com.pauliausprojektas.project.service;

import com.pauliausprojektas.project.model.Employee;
import com.pauliausprojektas.project.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployees() {
       return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
       return employeeRepository.save(employee);
    }
}
