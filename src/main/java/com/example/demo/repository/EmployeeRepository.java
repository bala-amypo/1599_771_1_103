package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Employee;

public interface EmployeeRepository {

    boolean existsByEmail(String email);

    Optional<Employee> findById(Long id);

    Optional<Employee> findByEmail(String email);

    List<Employee> findAll();

    Employee save(Employee employee);

    void delete(Employee employee);
}
