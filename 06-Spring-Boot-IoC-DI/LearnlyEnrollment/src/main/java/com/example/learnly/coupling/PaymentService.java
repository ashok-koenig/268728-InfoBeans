package com.example.learnly.coupling;

import com.example.learnly.model.Course;
import com.example.learnly.model.Student;

public class PaymentService {
    public void charge(Student student, Course course){
        System.out.println("Charged "+ student.name() + " INR "+ course.price());
    }
}
