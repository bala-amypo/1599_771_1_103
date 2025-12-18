package com.example.demo.controller;
import jakarta.validation.Valid;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee create(@Valid@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable Long id) {
        return employeeService.get(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        employeeService.delete(id);
        return "Employee deleted";
    }
}
