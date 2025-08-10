package com.example.demo.service;

import com.example.demo.model.students;
import com.example.demo.repository.srepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final srepository repository;

    public StudentService(srepository repository) {
        this.repository = repository;
    }

    public List<students> getAllStudents() {
        return repository.findAll();
    }
}
