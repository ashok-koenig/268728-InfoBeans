package com.example.learnly.coupling;

import com.example.learnly.model.SampleData;

public class Main {
    public static void main(String[] args) {
        EnrollmentController controller = new EnrollmentController();
        controller.enroll(SampleData.ASHA, SampleData.JAVA);
    }
}
