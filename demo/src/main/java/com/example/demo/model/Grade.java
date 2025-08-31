package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String examName;  // اسم الامتحان (مثلاً Midterm, Final)
    private Double mark;      // العلامة

    @ManyToOne
    private students student;

    @ManyToOne
    private ClassEntity classEntity;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getExamName() { return examName; }
    public void setExamName(String examName) { this.examName = examName; }

    public Double getMark() { return mark; }
    public void setMark(Double mark) { this.mark = mark; }

    public students getStudent() { return student; }
    public void setStudent(students student) { this.student = student; }

    public ClassEntity getClassEntity() { return classEntity; }
    public void setClassEntity(ClassEntity classEntity) { this.classEntity = classEntity; }
}
