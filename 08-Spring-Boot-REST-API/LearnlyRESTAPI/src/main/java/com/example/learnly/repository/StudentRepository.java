package com.example.learnly.repository;

import com.example.learnly.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {
    private final Map<Long, Student> students = new LinkedHashMap<>();
    private long nextId = 1;

    public StudentRepository() {
        save(new Student(null, "Asha", "asha@mail.com", "Pune", "$2a$10$asha6f2c9d"));
        save(new Student(null, "Bob", "bob@mail.com", "Mumbai", "$2a$10$bob41a7e03"));
        save(new Student(null, "Chitra", "chitra@mail.com", "Pune", "$2a$10$chitra9b8d12"));
        save(new Student(null, "Divya", "divya@mail.com", "Chennai", "$2a$10$divya77c0e5"));
        save(new Student(null, "Esha", "esha@mail.com", "Mumbai", "$2a$10$esha3d19fa"));
        save(new Student(null, "Farid", "farid@mail.com", "Pune", "$2a$10$farid5e8b60"));
    }

    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    public Optional<Student> findById(long id) {
        return Optional.ofNullable(students.get(id));
    }

    public Student save(Student student) {
        if (student.getId() == null) {
            student.setId(nextId++);
        }
        students.put(student.getId(), student);
        return student;
    }

    public boolean deleteById(long id) {
        return students.remove(id) != null;
    }
}
