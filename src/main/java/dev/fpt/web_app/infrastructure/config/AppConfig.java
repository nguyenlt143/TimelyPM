package dev.fpt.web_app.infrastructure.config;


import dev.fpt.web_app.infrastructure.config.property.JwtProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(JwtProperty.class)
public class AppConfig {
}
