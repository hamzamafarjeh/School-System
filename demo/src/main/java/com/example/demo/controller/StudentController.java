package com.example.school.controller;

import com.example.school.model.Student;
import com.example.school.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // GET /api/students
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }
}
