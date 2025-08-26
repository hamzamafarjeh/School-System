package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;


@Entity
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subjectName;
    private String grade;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private teachers teacher;

    @ManyToMany
    @JoinTable(
            name = "class_students",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<students> students;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSubjectName() { return subjectName; }
    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public teachers getTeacher() { return teacher; }
    public void setTeacher(teachers teacher) { this.teacher = teacher; }

    public List<students> getStudents() { return students; }
    public void setStudents(List<students> students) { this.students = students; }
}

