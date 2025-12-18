package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee createEmployee(Employee employee) {
        if (repository.existsByEmail(employee.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        return repository.save(employee);
    }

    public Employee getEmployee(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public void deleteEmployee(Long id) {
        repository.delete(getEmployee(id));
    }

    public List<Employee> getAll() {
        return repository.findAll();
    }
}
