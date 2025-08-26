package com.example.demo.controller;

import com.example.demo.model.ClassEntity;
import com.example.demo.repository.ClassRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/classes")
public class ClassController {
    private final ClassRepository classRepository;

    public ClassController(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    // إضافة Class جديد
    @PostMapping
    public ClassEntity createClass(@RequestBody ClassEntity classEntity) {
        return classRepository.save(classEntity);
    }

    // جلب جميع الـ Classes مع عدد الطلاب
    @GetMapping
    public List<String> getAllClassesWithStudentCount() {
        List<ClassEntity> classes = classRepository.findAll();
        return classes.stream()
                .map(c -> "Class: " + c.getSubjectName() + " | Grade: " + c.getGrade() +
                        " | Teacher: " + (c.getTeacher() != null ? c.getTeacher().getName() : "No teacher") +
                        " | Students count: " + (c.getStudents() != null ? c.getStudents().size() : 0))
                .collect(Collectors.toList());
    }
}
