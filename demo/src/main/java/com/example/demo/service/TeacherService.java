package com.example.demo.service;

import com.example.demo.model.teachers;
import com.example.demo.repository.trepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private final trepository repository;

    public TeacherService(trepository repository) {
        this.repository = repository;
    }

    public List<teachers> getAllTeachers() {return repository.findAll(); }

}
