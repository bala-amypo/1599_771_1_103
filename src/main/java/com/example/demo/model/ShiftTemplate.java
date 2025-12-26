package com.example.demo.model;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ShiftTemplate {

    private Long id;
    private String templateName;
    private LocalTime startTime;
    private LocalTime endTime;
    private String requiredSkills;
    private Department department;

    public ShiftTemplate() {}

    public ShiftTemplate(String templateName, LocalTime startTime, LocalTime endTime,
                         String requiredSkills, Department department) {
        this.templateName = templateName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.requiredSkills = requiredSkills;
        this.department = department;
    }

    public Set<String> getRequiredSkillsSet() {
        return Arrays.stream(requiredSkills.split(","))
                .map(String::trim)
                .collect(Collectors.toSet());
    }

    public String getTemplateName() { return templateName; }
    public void setTemplateName(String templateName) { this.templateName = templateName; }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }

    public String getRequiredSkills() { return requiredSkills; }
    public void setRequiredSkills(String requiredSkills) { this.requiredSkills = requiredSkills; }

    public Department getDepartment() { return department; }
}
