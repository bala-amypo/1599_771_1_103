package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceimpl implements EmployeeService {

    @Autowired
    private EmployeeRepository emprep;

    @Override
    public Employee createEmployee(Employee employee) {
        if (emprep.existsByEmail(employee.getEmail())) {
            throw new RuntimeException(
                "Employee with email " + employee.getEmail() + " already exists"
            );
        }
        return emprep.save(employee);
    }

    @Override
    public Employee getEmployee(Long id) {
        return emprep.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existing = getEmployee(id);

        existing.setFullName(employee.getFullName());
        existing.setSkills(employee.getSkills());
        existing.setMaxWeeklyHours(employee.getMaxWeeklyHours());
        existing.setRole(employee.getRole());

        return emprep.save(existing);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = getEmployee(id);
        emprep.delete(employee);
    }

    @Override
    public List<Employee> getAll() {
        return emprep.findAll();
    }
}
