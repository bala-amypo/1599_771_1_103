package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name = "generated_shift_schedules")
public class GeneratedShiftSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate shiftDate;

    private LocalTime startTime;

    private LocalTime endTime;

    @ManyToOne
    @JoinColumn(name = "shift_template_id")
    private ShiftTemplate shiftTemplate;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public GeneratedShiftSchedule() {}

    public GeneratedShiftSchedule(Long id,
                                  LocalDate shiftDate,
                                  LocalTime startTime,
                                  LocalTime endTime,
                                  ShiftTemplate shiftTemplate,
                                  Department department,
                                  Employee employee) {
        this.id = id;
        this.shiftDate = shiftDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.shiftTemplate = shiftTemplate;
        this.department = department;
        this.employee = employee;
    }

    public Long getId() { return id; }
    public LocalDate getShiftDate() { return shiftDate; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }
    public ShiftTemplate getShiftTemplate() { return shiftTemplate; }
    public Department getDepartment() { return department; }
    public Employee getEmployee() { return employee; }

    public void setId(Long id) { this.id = id; }
    public void setShiftDate(LocalDate shiftDate) { this.shiftDate = shiftDate; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }
    public void setShiftTemplate(ShiftTemplate shiftTemplate) {
        this.shiftTemplate = shiftTemplate;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
