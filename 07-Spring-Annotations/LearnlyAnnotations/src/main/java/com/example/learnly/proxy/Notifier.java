package com.example.learnly.proxy;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class Notifier {
    @Async("notificationExecutor")
    public CompletableFuture<String> send() {
        return CompletableFuture.completedFuture("Sent on thread "+ Thread.currentThread().getName());
    }
}
