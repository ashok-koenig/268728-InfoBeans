package com.example.learnly.imports;

import com.example.learnly.shared.TaxCalculator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class ImportsApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ImportsApp.class, args);

        boolean found = context.containsBean("taxCalculator");
        System.out.println("Tax calculator bean found: "+ found);

        if(found){
            TaxCalculator tax = context.getBean(TaxCalculator.class);
            System.out.println("GST on 4999.00: "+ tax.gst(new BigDecimal("4999.00")));
        }
        context.close();
    }
}
