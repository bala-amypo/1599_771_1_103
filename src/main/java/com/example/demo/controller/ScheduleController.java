package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.GeneratedShiftSchedule;
import com.example.demo.service.ScheduleService;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/generate/{date}")
    public List<GeneratedShiftSchedule> generate(@PathVariable LocalDate date) {
        return scheduleService.generateForDate(date);
    }

    @GetMapping("/date/{date}")
    public List<GeneratedShiftSchedule> getByDate(@PathVariable LocalDate date) {
        return scheduleService.getByDate(date);
    }
}
