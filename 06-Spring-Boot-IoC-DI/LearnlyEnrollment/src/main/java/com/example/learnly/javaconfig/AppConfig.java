package com.example.learnly.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;

@Configuration
public class AppConfig {
    @Bean
    public PriceFormatter priceFormatter(){
        return new PriceFormatter("INR");
    }

    @Bean
    public Clock clock(){
        return Clock.fixed(Instant.now(), ZoneOffset.UTC);
    }
}
