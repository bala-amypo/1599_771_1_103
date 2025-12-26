package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;

public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public Response<Department> get(Long id) {
        return new Response<>(departmentService.get(id));
    }

    public Response<List<Department>> list() {
        return new Response<>(departmentService.getAll());
    }

    public Response<String> delete(Long id) {
        departmentService.delete(id);
        return new Response<>("Deleted");
    }
}
