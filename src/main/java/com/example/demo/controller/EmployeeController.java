package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // ================= REGISTER EMPLOYEE =================
    @PostMapping("/register")
    public Employee register(@RequestBody EmployeeDto dto) {

        Employee employee = new Employee();
        employee.setFullName(dto.getFullName());
        employee.setEmail(dto.getEmail());
        employee.setRole(dto.getRole());
        employee.setSkills(dto.getSkills());
        employee.setMaxWeeklyHours(dto.getMaxWeeklyHours());

        return employeeService.createEmployee(employee);
    }

    // ================= GET ALL EMPLOYEES =================
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    // ================= GET EMPLOYEE BY ID =================
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    // ================= DELETE EMPLOYEE =================
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully";
    }
}
