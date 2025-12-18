package com.example.demo.service.impl;

import com.example.demo.model.Department;
import com.example.demo.model.ShiftTemplate;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.ShiftTemplateRepository;
import com.example.demo.service.ShiftTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftTemplateServiceImpl implements ShiftTemplateService {

    @Autowired
    private ShiftTemplateRepository shiftTemplateRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public ShiftTemplate create(Long departmentId, ShiftTemplate template) {

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        if (template.getEndTime().isBefore(template.getStartTime())
                || template.getEndTime().equals(template.getStartTime())) {
            throw new RuntimeException("Shift end time must be after start time");
        }

        shiftTemplateRepository
                .findByTemplateNameAndDepartment_Id(
                        template.getTemplateName(), departmentId)
                .ifPresent(t -> {
                    throw new RuntimeException("Template name must be unique");
                });

        template.setDepartment(department);
        return shiftTemplateRepository.save(template);
    }

    @Override
    public List<ShiftTemplate> getByDepartment(Long departmentId) {
        return shiftTemplateRepository.findByDepartment_Id(departmentId);
    }

    @Override
    public ShiftTemplate getTemplate(Long id) {
        return shiftTemplateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Template not found"));
    }
}
