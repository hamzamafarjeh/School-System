package com.example.demo.repository;

import com.example.demo.dto.ClassDTO;
import com.example.demo.model.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Long>{
    @Query("SELECT new com.example.demo.dto.ClassDTO(c.subjectName, c.grade, t.name, COUNT(s)) " +
            "FROM ClassEntity c " +
            "LEFT JOIN c.teacher t " +
            "LEFT JOIN c.students s " +
            "GROUP BY c.id, c.subjectName, c.grade, t.name")
    List<ClassDTO> findAllClassesWithStudentCount();

}
