package com.example.learnly.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ConfigPrinter implements CommandLineRunner {

    private final Environment env;

    public ConfigPrinter(Environment env) {
        this.env = env;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("application: " + env.getProperty("spring.application.name"));
    }
}
