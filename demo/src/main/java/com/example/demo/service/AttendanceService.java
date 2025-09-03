package com.example.demo.service;


import com.example.demo.model.Attendance;
import com.example.demo.model.students;
import com.example.demo.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private EmailService emailService;

    public Attendance saveAttendance(Attendance attendance) {
        Attendance saved = attendanceRepository.save(attendance);

        if (!attendance.isPresent()) { // الطالب غاب
            students student = attendance.getStudent();
            if (student.getFatherEmail() != null) {
                emailService.sendAbsenceEmail(
                        student.getFatherEmail(),
                        student.getName(),
                        attendance.getDate().toString(),
                        attendance.getClassEntity().getSubjectName()
                );
            }
        }


        return saved;
    }
}
