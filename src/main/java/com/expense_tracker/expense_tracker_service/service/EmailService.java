package com.expense_tracker.expense_tracker_service.service;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String emailSource;

    private final String html = """
            <html>
            <head>
              <meta charset="UTF-8">
              <title>Reset Your Password</title>
            </head>
            <body style="font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;">
              <div style="max-width: 600px; margin: auto; background: #ffffff; padding: 30px; border-radius: 8px;">
                <h2 style="color: #333;">Reset Your Password</h2>
                <p>Hi {{userName}},</p>
                <p>You recently requested to reset your password for your account. Click the button below to reset it:</p>
                <p style="text-align: center;">
                  <a href="{{resetLink}}" style="display: inline-block; padding: 12px 24px; background-color: #007BFF; color: white; text-decoration: none; border-radius: 5px;">
                    Reset Password
                  </a>
                </p>
                <p>This link will expire in 30 minutes. If you didn’t request a password reset, you can safely ignore this email.</p>
                <p>Thanks,<br>Your Company Name</p>
                <hr style="margin: 40px 0;">
                <p style="font-size: 12px; color: #777;">If you're having trouble clicking the "Reset Password" button, copy and paste the URL below into your web browser:</p>
                <p style="font-size: 12px; color: #007BFF;">{{resetLink}}</p>
              </div>
            </body>
            </html>""";
    public void sendHtmlMail(String to, String subject) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setFrom(emailSource);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(html, true); // true = enable HTML

            log.info("EmailService::sendHtmlMail:: before sending email : {}", subject);
            mailSender.send(message);
            log.info("EmailService::sendHtmlMail:: Sending Success");

        } catch (MessagingException e) {
            log.error("Error while sending email :: ", e);
            throw new RuntimeException(e);
        }
    }
}
