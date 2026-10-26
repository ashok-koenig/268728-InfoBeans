package com.example.learnly.collections;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class EmailNotifier implements Notifier{
    @Override
    public String channel() {
        return "email";
    }

    @Override
    public void send(String to, String message) {
        System.out.println("[email] to "+ to + ":" + message);
    }
}
