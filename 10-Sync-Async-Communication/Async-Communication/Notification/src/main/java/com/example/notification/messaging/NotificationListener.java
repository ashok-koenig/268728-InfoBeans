package com.example.notification.messaging;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {
    private final ProcessedEvents processed;

    public NotificationListener(ProcessedEvents processed) {
        this.processed = processed;
    }

    @JmsListener(destination = Destinations.ENROLLMENT)
    public void onEnrollment(EnrollmentEvent event, Message raw) throws JMSException {

        int attempt = raw.getIntProperty("JMSXDeliveryCount");

        if(processed.contains(event.eventId())){
            System.out.println("Skipped duplicate: "+ event.eventId());
            return;
        }

        if(event.course() == null || event.course().isBlank()){
            System.out.println(event.eventId() + " attempt " + attempt + " failed: course is missing");
            throw new IllegalArgumentException("course is missing");
        }


        System.out.println(raw.getJMSMessageID() + " correlation=" + raw.getJMSCorrelationID()
        + " businessId= "+ raw.getStringProperty("businessId"));

        System.out.println("Welcome email to "+ event.studentName() +
                " <email: "+ event.email() + ", course: "+ event.course() + ">, attempt: "+ attempt);

        processed.markDone(event.eventId());
    }
//    @JmsListener(destination = Destinations.ENROLLMENT)
//    public void onMessage(String text){
//        System.out.println("Welcome email: "+ text);
//    }
}
