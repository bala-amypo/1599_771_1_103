package com.example.demo.model;

import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name = "shift_templates")
public class ShiftTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String templateName;

    private LocalTime startTime;

    private LocalTime endTime;

    private String requiredSkills;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public ShiftTemplate() {}

    public ShiftTemplate(Long id,
                         String templateName,
                         LocalTime startTime,
                         LocalTime endTime,
                         String requiredSkills,
                         Department department) {
        this.id = id;
        this.templateName = templateName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.requiredSkills = requiredSkills;
        this.department = department;
    }

    public Long getId() { return id; }
    public String getTemplateName() { return templateName; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }
    public String getRequiredSkills() { return requiredSkills; }
    public Department getDepartment() { return department; }

    public void setId(Long id) { this.id = id; }
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
}
