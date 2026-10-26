package com.example.learnly.collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CollectionsApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CollectionsApp.class, args);

        NotificationCenter center = context.getBean(NotificationCenter.class);
        center.broadcast("asha@mail.com", "Welcome to Java Foundations");

        System.out.println("Bean names: "+ center.beenNames());
        center.via("smsNotifier", "+91-98765 43210", "Your class starts tomorrow");
        context.close();
    }
}
