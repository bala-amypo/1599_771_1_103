package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {

        if (employeeRepository.existsByEmail(employee.getEmail())) {
            throw new RuntimeException("Employee already exists");
        }

        if (employee.getMaxWeeklyHours() <= 0) {
            throw new RuntimeException("Max weekly hours must be greater than 0");
        }

        return employeeRepository.save(employee);
    }

    @Override
    public Employee get(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        employeeRepository.delete(get(id));
    }
}
