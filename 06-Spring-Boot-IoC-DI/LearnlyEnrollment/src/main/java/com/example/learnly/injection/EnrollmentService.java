package com.example.learnly.injection;

import com.example.learnly.model.Course;
import com.example.learnly.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {
    private final PaymentGateway gateway;
    private CertificateTemplate template;

    // Constructor injection: no @Autowired is required
    public EnrollmentService(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    // Setter injection
    @Autowired(required = false)
    public void setTemplate(CertificateTemplate template){
        this.template = template;
    }

    public String enroll(Student student, Course course){
//        return gateway.charge(student, course);
        String certificate = template == null
                ? "Plain certificate for "+ student.name()
                : template. text(student, course);
        return gateway.charge(student, course) + " | "+ certificate;
    }
}
