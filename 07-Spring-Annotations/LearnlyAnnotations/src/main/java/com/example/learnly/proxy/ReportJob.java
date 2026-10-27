package com.example.learnly.proxy;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ReportJob {
    private final AtomicInteger ticks = new AtomicInteger();

    @Scheduled(fixedRate = 200)
    public void tick(){
        ticks.incrementAndGet();
    }

    public int ticks() {
        return ticks.get();
    }
}
