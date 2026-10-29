package com.example.dlqtool.tools;

import com.example.dlqtool.messaging.Destinations;
import jakarta.jms.Message;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.Enumeration;

@Component
@Profile("inspect-dlq")
public class DlqInspector implements CommandLineRunner {
    private final JmsTemplate jmsTemplate;

    public DlqInspector(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        Integer count = jmsTemplate.browse(Destinations.DLQ, ((session, browser) -> {
            int n =0;
            Enumeration<?> messages = browser.getEnumeration();
            while (messages.hasMoreElements()){
                Message message = (Message) messages.nextElement();
                System.out.println("Dead letter: businessId: "+ message.getStringProperty("businessId")
                        + ", from "+ message.getStringProperty("_AMQ_ORIG_ADDRESS"));
                n++;
            }
            return n;
        }));
        System.out.println("Messages in "+ Destinations.DLQ + ": "+ count);
    }
}
