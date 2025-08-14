package com.example.demo.controller;

import com.example.demo.model.teachers;
import com.example.demo.repository.trepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private trepository teacherRepository;


    @PostMapping
    public teachers createTeacher(@RequestBody teachers Teacher) {
        return teacherRepository.save(Teacher);
    }

    @GetMapping("/{id}")
    public ResponseEntity<teachers> getStudentById(@PathVariable int id) {
        Optional<teachers> optionalTeacher = teacherRepository.findById(id);

        if (optionalTeacher.isPresent()) {

            return ResponseEntity.ok(optionalTeacher.get());
        } else {

            return ResponseEntity.notFound().build();
        }
    }
}
