package com.example.learnly.coupling;

import com.example.learnly.model.Course;
import com.example.learnly.model.Student;

public class EnrollmentController {
    // Hard-wired
    private final PaymentService payment = new PaymentService();

    public void enroll(Student student, Course course){
        payment.charge(student, course);
        System.out.println(student.name() + " enrolled in "+ course.title());
    }
}
