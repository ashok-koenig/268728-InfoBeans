package com.example.learnly.collections;

public interface Notifier {
    String channel();

    void send(String to, String message);
}
