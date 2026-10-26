package com.example.learnly.collections;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class WhatsAppNotifier implements Notifier{
    @Override
    public String channel() {
        return "whatsapp";
    }

    @Override
    public void send(String to, String message) {
        System.out.println("[whatsapp] to "+ to + ":" + message);
    }
}
