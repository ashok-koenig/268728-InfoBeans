package com.example.learnly.injection;

import com.example.learnly.model.Course;
import com.example.learnly.model.SampleData;
import com.example.learnly.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class InjectionApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(InjectionApp.class, args);

        EnrollmentService service = context.getBean(EnrollmentService.class);
        System.out.println(service.enroll(SampleData.ASHA, SampleData.JAVA));

        System.out.println(context.getBean(ReportService.class).summary());

        try{
            new ReportService().summary();
        } catch (NullPointerException e){
            System.out.println("new ReportService fails: the hidden dependency is null");
        }

        EnrollmentService fake = new EnrollmentService(new PaymentGateway(){
            @Override
            public String charge(Student student, Course course) {
                return "Fake charge for "+ student.name();
            }
        });
        System.out.println(fake.enroll(SampleData.BOB, SampleData.SQL));
        context.close();
    }
}
