package com.example.learnly.interfaces;

import com.example.learnly.model.SampleData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class InterfacesApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(InterfacesApp.class, args);
        System.out.println(context.getBean(PricingService.class).quote(SampleData.JAVA));
        context.close();
    }
}
