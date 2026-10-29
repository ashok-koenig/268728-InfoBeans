package com.example.dlqtool.tools;

import com.example.dlqtool.messaging.Destinations;
import com.example.dlqtool.messaging.EnrollmentEvent;
import jakarta.jms.Message;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Profile("resubmit-dlq")
public class DlqResubmitter implements CommandLineRunner {
    private final JmsTemplate jmsTemplate;

    public DlqResubmitter(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        Message deed = jmsTemplate.receive(Destinations.DLQ);
        if(deed == null){
            System.out.println("The ded-letter queue is empty");
            return;
        }
        String original = deed.getStringProperty("_AMQ_ORIG_ADDRESS");
        EnrollmentEvent broken = (EnrollmentEvent) jmsTemplate.getMessageConverter().fromMessage(deed);
        EnrollmentEvent fixed = new EnrollmentEvent(broken.eventId(),
                broken.studentName(), broken.email(),"Spring Boot Essentials");
        jmsTemplate.convertAndSend(original, fixed, message -> {
            message.setJMSCorrelationID(fixed.eventId());
            message.setStringProperty("businessId", fixed.eventId());
            return message;
        });
        System.out.println("Resumitted "+ fixed.eventId() + " to " + original);
    }
}
