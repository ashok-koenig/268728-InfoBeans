package com.example.learnly.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ContainerApp {
    public static void main(String[] args) {
       ConfigurableApplicationContext context = SpringApplication.run(ContainerApp.class,args);

        List<String> allBeans = Arrays.stream(context.getBeanDefinitionNames())
                .filter(name -> {
                    Class<?> type = context.getType(name);
                    return type !=null && type.getPackageName().equals("com.example.learnly.container");
                })
                .toList();

        System.out.println("Beans in package container: "+ allBeans);

        CatalogService service = context.getBean(CatalogService.class);
        System.out.println("Catalogue: "+ service.titles());

        System.out.println("outsideService is a bean: "+ context.containsBean("outsideService"));

       context.close();
    }
}
