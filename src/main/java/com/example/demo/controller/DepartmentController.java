package com.example.demo.controller;
import jakarta.validation.Valid;
import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department create(@Valid@RequestBody Department department) {
        return departmentService.create(department);
    }

    @GetMapping
    public List<Department> getAll() {
        return departmentService.getAll();
    }

    @GetMapping("/{id}")
    public Department get(@PathVariable Long id) {
        return departmentService.get(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        departmentService.delete(id);
        return "Department deleted";
    }
}
