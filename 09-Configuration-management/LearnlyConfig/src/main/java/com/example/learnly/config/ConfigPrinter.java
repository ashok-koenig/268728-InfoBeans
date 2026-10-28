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

        System.out.println("mail host   : " + env.getProperty("learnly.mail.host"));
        System.out.println("mail port   : " + env.getProperty("learnly.mail.port"));
        System.out.println("retry count : " + env.getProperty("learnly.mail.retry-count"));
        System.out.println("database url: " + env.getProperty("learnly.datasource.url"));

    }
}
