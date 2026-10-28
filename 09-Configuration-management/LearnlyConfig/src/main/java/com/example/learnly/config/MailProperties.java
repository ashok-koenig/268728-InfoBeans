package com.example.learnly.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "learnly.mail")
public record MailProperties(
        String host,
        int port,
        String sender,
        int retryCount,
        boolean enabled
) {

}
