package com.example.learnly.javaconfig;

import com.example.learnly.model.Course;
import com.example.learnly.model.Student;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDate;

@Service
public class ReceiptService {
    private final PriceFormatter formatter;
    private final Clock clock;

    public ReceiptService(PriceFormatter formatter, Clock clock) {
        this.formatter = formatter;
        this.clock = clock;
    }

    public String receipt(Student student, Course course){
        return "Receipt "+ LocalDate.now(clock) + " for "+ student.name() + ": "
                + course.title()+ ", "+ formatter.format(course.price());
    }
}
