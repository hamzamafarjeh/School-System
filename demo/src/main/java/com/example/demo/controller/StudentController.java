package com.example.demo.controller;

import com.example.demo.model.students;
import com.example.demo.repository.srepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private srepository studentRepository;


    @PostMapping
    public String createStudent() {
        return "Hello World";
    }

    @GetMapping("/{id}")
    public Optional<students> getStudent(@PathVariable int id) {
        return studentRepository.findById(id);
    }
}

