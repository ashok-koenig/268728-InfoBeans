package com.example.learnly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class LearnlyConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnlyConfigApplication.class, args);
    }

}
