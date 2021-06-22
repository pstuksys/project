package com.pauliausprojektas.project.repositories;

import com.pauliausprojektas.project.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByUsername(String username);

    @Query("SELECT s FROM Employee s WHERE s.email = ?1")
    Optional<Employee> findByEmail(String email);
}
