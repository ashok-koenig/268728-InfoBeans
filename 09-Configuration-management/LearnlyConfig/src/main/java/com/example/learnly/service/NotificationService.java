package com.example.learnly.service;

import com.example.learnly.config.MailProperties;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final MailProperties mail;

    public NotificationService(MailProperties mail) {
        this.mail = mail;
    }

    public String send(String to, String text){
        return "sent "+ text + " to " + to + " via " + mail.host() + " : "+ mail.port();
    }
}
