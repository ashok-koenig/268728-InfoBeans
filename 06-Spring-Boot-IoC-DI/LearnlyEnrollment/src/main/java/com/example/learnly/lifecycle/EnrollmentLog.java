package com.example.learnly.lifecycle;

import com.example.learnly.model.Course;
import com.example.learnly.model.SampleData;
import com.example.learnly.model.Student;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EnrollmentLog {
    private PriceFormatter formatter;
    private List<Course> courses;
    private final List<String> entries = new ArrayList<>();
    public EnrollmentLog() {
        System.out.println("1. constructor: the log object exists");
    }

    @Autowired
    public void setFormatter(PriceFormatter formatter) {
        this.formatter = formatter;
        System.out.println("2. injection: the formatter arrived.");
    }

    @PostConstruct
    public void open(){
        courses = SampleData.courses();
        System.out.println("3. @PostConstruct: the log is open with "+ courses.size() + " courses");
    }

    public void record(Student student, Course course){
        entries.add(student.name() + " -> " + course.title() + ": "+ formatter.format(course.price()));
    }

    @PreDestroy
    public void close(){
        System.out.println("@PreDestroy: flushed " + entries.size() + " enrollments");
        entries.forEach( entry -> System.out.println(" "+ entry) );
    }
}
