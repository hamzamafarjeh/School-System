package com.example.demo.dto;

public class ClassDTO {
    private String subjectName;
    private String grade;
    private String teacherName;
    private Long studentCount;

    public ClassDTO(String subjectName, String grade, String teacherName, Long studentCount) {
        this.subjectName = subjectName;
        this.grade = grade;
        this.teacherName = teacherName;
        this.studentCount = studentCount;
    }


    public String getSubjectName() { return subjectName; }
    public String getGrade() { return grade; }
    public String getTeacherName() { return teacherName; }
    public Long getStudentCount() { return studentCount; }
}
