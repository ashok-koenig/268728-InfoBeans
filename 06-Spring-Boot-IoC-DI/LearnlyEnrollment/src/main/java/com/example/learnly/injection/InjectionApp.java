package com.example.learnly.injection;

import com.example.learnly.model.SampleData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class InjectionApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(InjectionApp.class, args);

        EnrollmentService service = context.getBean(EnrollmentService.class);
        System.out.println(service.enroll(SampleData.ASHA, SampleData.JAVA));

        context.close();
    }
}
