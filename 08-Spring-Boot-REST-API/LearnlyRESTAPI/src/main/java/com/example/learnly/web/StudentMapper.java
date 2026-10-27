package com.example.learnly.web;

import com.example.learnly.model.Student;

public class StudentMapper {
    private StudentMapper(){
    }

    public static Student toEntity(StudentRequest request){
        Student student = new Student();
        student.setName(request.name());
        student.setEmail(request.email());
        student.setCity(request.city());
        return student;
    }

    public static StudentResponse toResponse(Student student){
        return new StudentResponse(student.getId(),
                student.getName(), student.getEmail(),student.getCity());
    }
}
