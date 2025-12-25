package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.ShiftTemplate;
import com.example.demo.service.ShiftTemplateService;

@RestController
@RequestMapping("/api/templates")
public class ShiftTemplateController {

    private final ShiftTemplateService shiftTemplateService;

    public ShiftTemplateController(ShiftTemplateService shiftTemplateService) {
        this.shiftTemplateService = shiftTemplateService;
    }

    @PostMapping("/department/{departmentId}")
    public ShiftTemplate create(
            @PathVariable Long departmentId,
            @RequestBody ShiftTemplate template) {
        return shiftTemplateService.create(departmentId, template);
    }

    @GetMapping("/department/{departmentId}")
    public List<ShiftTemplate> getByDepartment(@PathVariable Long departmentId) {
        return shiftTemplateService.getByDepartment(departmentId);
    }

    @GetMapping("/{id}")
    public ShiftTemplate get(@PathVariable Long id) {
        return shiftTemplateService.getTemplate(id);
    }
}
