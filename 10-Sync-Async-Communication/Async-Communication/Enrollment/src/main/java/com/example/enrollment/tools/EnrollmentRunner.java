package com.example.enrollment.tools;

import com.example.enrollment.messaging.EventPublisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentRunner implements CommandLineRunner {
    private final EventPublisher publisher;

    public EnrollmentRunner(EventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Enrolling students");

        publisher.publish("Asha enrolled in Spring Boot Essentials");
    }
}
