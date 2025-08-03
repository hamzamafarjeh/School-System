package com.example.demo.repository;

import com.example.demo.model.students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface sRepository extends JpaRepository<students, Integer> {
        }

