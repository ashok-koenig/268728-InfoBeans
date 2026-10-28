package com.example.learnly.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ConfigPrinter implements CommandLineRunner {

    private final Environment env;
    private final String sender;
    private final MailProperties mail;

    public ConfigPrinter(Environment env, @Value("${learnly.mail.sender}") String sender, MailProperties mail) {
        this.env = env;
        this.sender = sender;
        this.mail = mail;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("application: " + env.getProperty("spring.application.name"));

        System.out.println("profiles: " + Arrays.toString(env.getActiveProfiles()));
        System.out.println("mail: "+ mail);
//        System.out.println("mail host   : " + env.getProperty("learnly.mail.host"));
//        System.out.println("mail port   : " + env.getProperty("learnly.mail.port"));
//        System.out.println("retry count : " + env.getProperty("learnly.mail.retry-count"));
//        System.out.println("sender: "+ sender);
        System.out.println("database url: " + env.getProperty("learnly.datasource.url"));

    }
}
