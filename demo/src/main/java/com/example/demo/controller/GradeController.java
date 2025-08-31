package com.example.demo.controller;

import com.example.demo.model.Grade;
import com.example.demo.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {
    @Autowired
    private GradeRepository gradeRepository;

    //  إضافة علامة
    @PostMapping
    public Grade addGrade(@RequestBody Grade grade) {
        return gradeRepository.save(grade);
    }

    //  إرجاع علامات طالب حسب id
    @GetMapping("/student/{studentId}")
    public List<Grade> getGradesByStudent(@PathVariable Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }
}
