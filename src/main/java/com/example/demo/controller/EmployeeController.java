package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Response<List<Employee>> list() {
        return new Response<>(employeeService.getAll());
    }

    public Response<Employee> get(Long id) {
        return new Response<>(employeeService.getEmployee(id));
    }

    public Response<String> delete(Long id) {
        employeeService.deleteEmployee(id);
        return new Response<>("Deleted");
    }
}
