package com.example.learnly.lifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentLog {
    private PriceFormatter formatter;
    public EnrollmentLog() {
        System.out.println("1. constructor: the log object exists");
    }

    @Autowired
    public void setFormatter(PriceFormatter formatter) {
        this.formatter = formatter;
        System.out.println("2. injection: the formatter arrived.");
    }
}
