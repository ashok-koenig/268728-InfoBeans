package com.example.notification.messaging;

import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ProcessedEvents {
    private final Set<String> seen = ConcurrentHashMap.newKeySet();

    public boolean contains(String eventId){
        return seen.contains(eventId);
    }

    public void markDone(String eventId){
        seen.add(eventId);
    }
}
