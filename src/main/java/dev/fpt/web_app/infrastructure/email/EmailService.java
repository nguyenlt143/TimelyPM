package dev.fpt.web_app.infrastructure.email;

import java.util.Map;

public interface EmailService {

    void sendEmailAsync(String email, String subject, String message);

    void sendTemplateEmailAsync(String subject, String emailTo, String templatePath, Map<String, Object> templateData);

    void sendEmail(String email, String subject, String message);

    void sendTemplateEmail(String subject, String emailTo, String templatePath, Map<String, Object> templateData);
}
