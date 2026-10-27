package com.example.learnly.imports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ImportsApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ImportsApp.class, args);

        boolean found = context.containsBean("taxCalculator");
        System.out.println("Tax calculator bean found: "+ found);
        context.close();
    }
}
