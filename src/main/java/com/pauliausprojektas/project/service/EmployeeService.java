package com.pauliausprojektas.project.service;

import com.pauliausprojektas.project.model.Employee;
import com.pauliausprojektas.project.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public void deleteEmployee(long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public void updateEmployee(Long employeeId, String lastName, String password, String email, String jobTitle) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new IllegalStateException("Employee with id " + employeeId + " has not been found"));

        if (lastName !=null && !Objects.equals(employee.getLastName(),lastName)){
            employee.setLastName(lastName);
        }

        if (password !=null && password.length()>8 && !Objects.equals(employee.getPassword(),password)) {
            employee.setPassword(password);
        }

        if (email !=null && email.length()>8 && !Objects.equals(employee.getEmail(), email)){
            //employee.setEmail(email);
            Optional<Employee> employeeOptional = employeeRepository.findByEmail(email);
            if (employeeOptional.isPresent()) {
                throw new IllegalStateException("Email is already taken");
            }
            employee.setEmail(email);
        }

        if (jobTitle !=null && !Objects.equals(employee.getJobTitle(),jobTitle)){
            employee.setJobTitle(jobTitle);
        }
    }
}
