package com.example.demo.controller;

import com.example.demo.model.Attendance;
import com.example.demo.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceRepository attendanceRepository;

    //  إضافة حضور/غياب
    @PostMapping
    public Attendance addAttendance(@RequestBody Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    //  جلب حضور طالب معين
    @GetMapping("/student/{studentId}")
    public List<Attendance> getAttendanceByStudent(@PathVariable Long studentId) {
        return attendanceRepository.findByStudentId(studentId);
    }
}
