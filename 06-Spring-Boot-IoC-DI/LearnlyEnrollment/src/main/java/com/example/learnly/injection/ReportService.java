package com.example.learnly.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    // Field injection
    @Autowired
    private PaymentGateway gateway;

    public String summary() {
        return "ReportService uses "+ gateway.getClass().getSimpleName();
    }
}
