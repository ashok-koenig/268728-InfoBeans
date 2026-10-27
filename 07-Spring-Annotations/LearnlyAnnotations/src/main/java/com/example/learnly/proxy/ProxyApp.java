package com.example.learnly.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProxyApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ProxyApp.class, args);

        System.out.println("Self call: " + context.getBean(BrokenReportService.class).run());

        System.out.println("Through a bean: "+ context.getBean(ReportService.class).run());
        context.close();
    }
}
