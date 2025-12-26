package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.model.GeneratedShiftSchedule;
import com.example.demo.service.ScheduleService;

public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    public Response<List<GeneratedShiftSchedule>> generate(String date) {
        LocalDate d = LocalDate.parse(date);
        return new Response<>(scheduleService.generateForDate(d));
    }

    public Response<List<GeneratedShiftSchedule>> byDate(String date) {
        LocalDate d = LocalDate.parse(date);
        return new Response<>(scheduleService.getByDate(d));
    }
}
