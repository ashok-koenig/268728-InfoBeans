package com.example.learnly.injection;

import com.example.learnly.model.Course;
import com.example.learnly.model.Student;
import org.springframework.stereotype.Component;

@Component
public class CertificateTemplate {
    public String text(Student student, Course course){
        return "Gold certificate for "+ student.name() + " ("+ course.title() + ")";
    }
}
