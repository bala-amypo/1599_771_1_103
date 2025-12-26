package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.ShiftTemplate;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.ShiftTemplateService;

public class ShiftTemplateController {

    private final ShiftTemplateService service;
    private final DepartmentRepository departmentRepository;

    public ShiftTemplateController(ShiftTemplateService service,
                                   DepartmentRepository departmentRepository) {
        this.service = service;
        this.departmentRepository = departmentRepository;
    }

    public Response<List<ShiftTemplate>> list() {
        return new Response<>(service.getByDepartment(
                departmentRepository.findAll().get(0).getId()
        ));
    }
}
