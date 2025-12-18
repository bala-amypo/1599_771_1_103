package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(Employee employee);
    Employee get(Long id);
    List<Employee> getAll();
    void delete(Long id);
}
