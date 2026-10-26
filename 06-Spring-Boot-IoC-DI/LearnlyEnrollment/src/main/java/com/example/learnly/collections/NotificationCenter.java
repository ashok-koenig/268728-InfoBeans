package com.example.learnly.collections;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

@Service
public class NotificationCenter {
    private final List<Notifier> notifiers;
    private final Map<String, Notifier> byName;

    public NotificationCenter(List<Notifier> notifiers, Map<String, Notifier> byName) {
        this.notifiers = notifiers;
        this.byName = byName;
    }

    public void broadcast(String to, String message){
        for(Notifier notifier: notifiers){
            notifier.send(to, message);
        }
    }

    public void via(String beanName, String to, String message){
        byName.get(beanName).send(to, message);
    }

    public TreeSet<String> beenNames(){
        return new TreeSet<>(byName.keySet());
    }
}
