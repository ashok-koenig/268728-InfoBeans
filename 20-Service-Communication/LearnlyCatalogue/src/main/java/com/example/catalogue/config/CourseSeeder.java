package com.example.catalogue.config;

import com.example.catalogue.entity.Course;
import com.example.catalogue.entity.CourseStatus;
import com.example.catalogue.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CourseSeeder implements CommandLineRunner {

    private final CourseRepository repository;

    public CourseSeeder(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(repository.count() > 0){
            return;
        }

        repository.save(new Course("Spring Boot Basics", CourseStatus.PUBLISHED, LocalDate.of(2026, 1, 10), "Backend", 500));
        repository.save(new Course("Kotlin for Java Developers", CourseStatus.PUBLISHED, LocalDate.of(2026, 2, 15), "Backend", 700));
        repository.save(new Course("Microservices with Spring", CourseStatus.PUBLISHED, LocalDate.of(2026, 3, 1), "Architecture", 900));
        repository.save(new Course("Advanced JPA", CourseStatus.DRAFT, LocalDate.of(2026, 12, 1), "Data", 600));
    }
}
