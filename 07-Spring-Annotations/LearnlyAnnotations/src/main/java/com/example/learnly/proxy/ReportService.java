package com.example.learnly.proxy;

import org.springframework.stereotype.Service;

@Service
public class ReportService {
    private final Notifier notifier;

    public ReportService(Notifier notifier) {
        this.notifier = notifier;
    }

    public String run(){
        return notifier.send().join();
    }
}
