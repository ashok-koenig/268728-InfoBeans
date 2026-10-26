package com.example.learnly.collections;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class SmsNotifier implements Notifier{
    @Override
    public String channel() {
        return "sms";
    }

    @Override
    public void send(String to, String message) {
        System.out.println("[sms] to "+ to + ":" + message);
    }
}
