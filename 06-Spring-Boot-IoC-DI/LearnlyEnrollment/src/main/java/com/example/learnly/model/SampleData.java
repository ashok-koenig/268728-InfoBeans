package com.example.learnly.model;

import java.math.BigDecimal;
import java.util.List;

public final class SampleData {
    public static final Course JAVA = new Course("JAVA101", "Java Foundations", new BigDecimal("4999.00"));
    public static final Course SPRING = new Course("SPRING201", "Spring Boot Essentials", new BigDecimal("7999.00"));
    public static final Course SQL = new Course("SQL110", "SQL in a Week", new BigDecimal("2999.00"));

    public static final Student ASHA = new Student("Asha", "asha@mail.com", true);
    public static final Student BOB = new Student("Bob", "bob@mail.com", false);

    private SampleData() {
    }

    public static List<Course> courses() {
        return List.of(JAVA, SPRING, SQL);
    }
}
