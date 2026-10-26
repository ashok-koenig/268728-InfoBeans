package com.example.learnly.scopes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ScopesApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ScopesApp.class, args);

        // Singleton
        System.out.println("Same CourseCatalog: "+
                (context.getBean(CourseCatalog.class) == context.getBean(CourseCatalog.class)));
        System.out.println("Same WelcomePack: "+
                (context.getBean(WelcomePack.class) == context.getBean(WelcomePack.class)));

        EnrollmentDesk desk = context.getBean(EnrollmentDesk.class);
        System.out.println(desk.issue());
        System.out.println(desk.issue());
        context.close();
    }
}
