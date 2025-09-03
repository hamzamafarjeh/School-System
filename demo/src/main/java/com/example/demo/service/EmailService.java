package com.example.demo.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendAbsenceEmail(String toEmail, String studentName, String date, String subjectName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("غياب الطالب: " + studentName);
        message.setText("ابنك " + studentName + " غاب عن حصة " + subjectName + " بتاريخ " + date);
        mailSender.send(message);
    }
}
