package com.example.learnly.config;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "learnly.mail")
@Validated
public record MailProperties(
        @NotBlank
        String host,
        @Min(1) @Max(65535)
        int port,
        @NotBlank @Email
        String sender,
        @Min(0) @Max(10)
        int retryCount,
        boolean enabled,
        String password
) {
        @Override
        public String toString() {
                return "MailProperties{" +
                        "host='" + host + '\'' +
                        ", port=" + port +
                        ", sender='" + sender + '\'' +
                        ", retryCount=" + retryCount +
                        ", enabled=" + enabled +
                        ", password=******* " +
                        '}';
        }
}
