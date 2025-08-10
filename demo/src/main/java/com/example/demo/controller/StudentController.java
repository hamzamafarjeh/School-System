package com.example.demo.controller;

import com.example.demo.model.students;
import com.example.demo.repository.srepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private srepository studentRepository;


    @PostMapping
    public students createStudent(@RequestBody students student) {
        return studentRepository.save(student);
    }
}

