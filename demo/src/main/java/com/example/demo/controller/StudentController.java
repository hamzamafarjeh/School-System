package com.example.demo.controller;

import com.example.demo.model.students;
import com.example.demo.repository.srepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private srepository studentRepository;


    @PostMapping
    public students createStudent(@RequestBody students Student) {
        return studentRepository.save(Student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<students> getStudentById(@PathVariable int id) {
        Optional<students> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            // إذا الطالب موجود → رجعه مع status 200
            return ResponseEntity.ok(optionalStudent.get());
        } else {
            // إذا مش موجود → رجع 404
            return ResponseEntity.notFound().build();
        }
    }


}

