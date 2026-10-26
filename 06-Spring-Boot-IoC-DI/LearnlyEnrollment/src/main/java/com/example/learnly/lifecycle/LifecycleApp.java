package com.example.learnly.lifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LifecycleApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LifecycleApp.class, args);
        EnrollmentLog log = context.getBean(EnrollmentLog.class);
        context.close();
    }
}
