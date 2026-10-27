package com.example.learnly.shared;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SharedConfig {
    @Bean
    public TaxCalculator taxCalculator(){
        return new TaxCalculator();
    }
}
