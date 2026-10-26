package com.example.learnly.injection;

import com.example.learnly.model.Course;
import com.example.learnly.model.Student;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {
    private final PaymentGateway gateway;

    // Constructor injection: no @Autowired is required
    public EnrollmentService(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public String enroll(Student student, Course course){
        return gateway.charge(student, course);
    }
}
