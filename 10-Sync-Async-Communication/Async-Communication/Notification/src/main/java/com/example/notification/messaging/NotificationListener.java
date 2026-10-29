package com.example.notification.messaging;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {
    @JmsListener(destination = Destinations.ENROLLMENT)
    public void onEnrollment(EnrollmentEvent event, Message raw) throws JMSException {
        int attempt = raw.getIntProperty("JMSXDeliveryCount");
        System.out.println(raw.getJMSMessageID() + " correlation=" + raw.getJMSCorrelationID()
        + " businessId= "+ raw.getStringProperty("businessId"));

        System.out.println("Welcome email to "+ event.studentName() +
                " <email: "+ event.email() + ", course: "+ event.course() + ">, attempt: "+ attempt);
    }
//    @JmsListener(destination = Destinations.ENROLLMENT)
//    public void onMessage(String text){
//        System.out.println("Welcome email: "+ text);
//    }
}
