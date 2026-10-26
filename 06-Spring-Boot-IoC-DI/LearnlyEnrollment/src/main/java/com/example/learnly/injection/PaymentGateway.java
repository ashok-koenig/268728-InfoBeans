package com.example.learnly.injection;

import com.example.learnly.model.Course;
import com.example.learnly.model.Student;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {
    public String charge(Student student, Course course){
        return "Charged "+ student.name() + " INR "+ course.price();
    }
}
