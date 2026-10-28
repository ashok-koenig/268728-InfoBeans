package com.example.enrollment;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrollmentController {
    private final CatalogueClient catalogueClient;

    public EnrollmentController(CatalogueClient catalogueClient) {
        this.catalogueClient = catalogueClient;
    }

    @PostMapping("/enrollments")
    public EnrollmentReply enroll(@RequestBody EnrollmentRequest request){
        Course course = catalogueClient.find(request.courseId());
        return new EnrollmentReply(request.studentName() + " has a seat in "+ course.title() +
                " seats left: "+ course.seatsLeft());
    }
}
