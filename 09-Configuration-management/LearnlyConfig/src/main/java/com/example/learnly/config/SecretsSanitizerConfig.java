package com.example.learnly.config;

import org.springframework.boot.actuate.endpoint.SanitizingFunction;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;

@Configuration
@Profile({"safe", "prod"})
public class SecretsSanitizerConfig {

    @EventListener(ApplicationReadyEvent.class)
    void safeNotice() {
        System.out.println("safe profile: secret values are masked in Actuator");
    }

    @Bean
    SanitizingFunction secretsSanitizer(){
        return SanitizingFunction.sanitizeValue().ifKeyContains("password", "secret");
    }

}
