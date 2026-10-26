package com.example.learnly.container;

import com.example.learnly.model.Course;
import com.example.learnly.model.SampleData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepository {
    public List<Course> findAll(){
        return SampleData.courses();
    }
}
