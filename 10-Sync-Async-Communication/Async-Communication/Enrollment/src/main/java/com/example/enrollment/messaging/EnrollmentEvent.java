package com.example.enrollment.messaging;

public record EnrollmentEvent(String eventId, String studentName, String email, String course) {
}
