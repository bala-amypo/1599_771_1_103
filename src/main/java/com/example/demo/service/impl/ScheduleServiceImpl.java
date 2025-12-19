package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ShiftTemplateRepository shiftTemplateRepository;

    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private GeneratedShiftScheduleRepository scheduleRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<GeneratedShiftSchedule> generateForDate(LocalDate date) {

        List<GeneratedShiftSchedule> result = new ArrayList<>();

        List<Department> departments = departmentRepository.findAll();

        for (Department department : departments) {

            List<ShiftTemplate> templates =
                    shiftTemplateRepository.findByDepartment_Id(department.getId());

            for (ShiftTemplate template : templates) {

                List<EmployeeAvailability> availableList =
                        availabilityRepository.findByAvailableDateAndAvailable(date, true);

                for (EmployeeAvailability availability : availableList) {

                    Employee employee = availability.getEmployee();

                    if (employee.getSkills() != null &&
                        template.getRequiredSkills() != null &&
                        employee.getSkills().contains(template.getRequiredSkills())) {

                        GeneratedShiftSchedule schedule =
                                new GeneratedShiftSchedule();

                        schedule.setShiftDate(date);
                        schedule.setStartTime(template.getStartTime());
                        schedule.setEndTime(template.getEndTime());
                        schedule.setShiftTemplate(template);
                        schedule.setDepartment(department);
                        schedule.setEmployee(employee);

                        scheduleRepository.save(schedule);
                        result.add(schedule);
                        break;
                    }
                }
            }
        }

        if (result.isEmpty()) {
            throw new RuntimeException("Schedules not found");
        }

        return result;
    }

    @Override
    public List<GeneratedShiftSchedule> getByDate(LocalDate date) {

        List<GeneratedShiftSchedule> schedules =
                scheduleRepository.findByShiftDate(date);

        if (schedules.isEmpty()) {
            throw new RuntimeException("Schedules not found");
        }
        return schedules;
    }
}
