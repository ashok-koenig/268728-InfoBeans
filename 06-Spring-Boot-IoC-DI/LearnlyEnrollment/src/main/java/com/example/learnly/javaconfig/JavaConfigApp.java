package com.example.learnly.javaconfig;

import com.example.learnly.model.SampleData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JavaConfigApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JavaConfigApp.class, args);

        ReceiptService receipt = context.getBean(ReceiptService.class);
        System.out.println(receipt.receipt(SampleData.ASHA, SampleData.JAVA));

        // The bean name is the method name
        System.out.println("priceFormatter is a been: "+ context.containsBean("priceFormatter"));
        System.out.println("clock is a been: "+ context.containsBean("clock"));

        context.close();
    }
}
