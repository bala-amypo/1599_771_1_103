package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/register")
    public Employee register(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/all")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully";
    }
}
