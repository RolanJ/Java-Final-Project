package com.example.javafinalproject.Services;

import com.example.javafinalproject.Repositories.JumagulovRolanNotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class JumagulovRolanNotificationService {
    private final JumagulovRolanNotificationRepository notifRepository;
    private final JavaMailSender mailSender;

    @Async
    public void sendNotification(String studentEmail, String courseName) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("iitu@gmail.com");
            message.setTo(studentEmail);
            message.setSubject("Enrollment Notification");
            message.setText("You have been successfully enrolled in the course " + courseName);
            mailSender.send(message);
            log.info("Successfully sent notification");

        }
        catch (Exception e) {
            log.error("Couldn't send notification", e.getMessage());

        }

    }
}
