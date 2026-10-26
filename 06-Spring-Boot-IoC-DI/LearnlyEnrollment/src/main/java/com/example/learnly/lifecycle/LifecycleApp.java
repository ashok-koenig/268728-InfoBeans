package com.example.learnly.lifecycle;

import com.example.learnly.model.SampleData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LifecycleApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LifecycleApp.class, args);
        EnrollmentLog log = context.getBean(EnrollmentLog.class);
        log.record(SampleData.ASHA, SampleData.JAVA);
        log.record(SampleData.BOB, SampleData.SPRING);
        System.out.println("Closing the application...");
        context.close();
    }
}
