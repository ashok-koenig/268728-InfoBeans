package com.example.notification.messaging;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {
    @JmsListener(destination = Destinations.ENROLLMENT)
    public void onMessage(String text){
        System.out.println("Welcome email: "+ text);
    }
}
