package com.example.enrollment.messaging;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher {
    private final JmsTemplate jmsTemplate;

    public EventPublisher(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void publish(EnrollmentEvent event){
        jmsTemplate.convertAndSend(Destinations.ENROLLMENT, event, message -> {
            message.setJMSCorrelationID(event.eventId());
            message.setStringProperty("businessId", event.eventId());
            return message;
        });
    }

//    public void publish(String text){
//        jmsTemplate.convertAndSend(Destinations.ENROLLMENT, text);
//    }

}
