package dev.fpt.web_app.infrastructure.email;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;


    @Async
    @Override
    public void sendEmailAsync(String email, String subject, String message) {
        sendEmail(email, subject, message);
    }

    @Async
    @Override
    public void sendTemplateEmailAsync(String subject, String emailTo, String templatePath, Map<String, Object> templateData) {
        sendTemplateEmail(subject, emailTo, templatePath, templateData);
    }

    @Override
    public void sendEmail(String email, String subject, String message) {
        send(subject, email, message, false);
    }

    @Override
    public void sendTemplateEmail(String subject, String emailTo, String templatePath, Map<String, Object> templateData) {
        Context templateContext = new Context();
        templateContext.setVariables(templateData);
        String content = templateEngine.process(templatePath, templateContext);
        send(subject, emailTo, content, true);
    }

    private void send(String subject, String emailTo, String content, boolean isHtmlFormat) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "utf-8");

            message.setSubject(subject);
            message.setText(content, isHtmlFormat);
            message.setTo(emailTo);

            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new IllegalStateException("Failed to send email to " + emailTo, e);
        }
    }
}
