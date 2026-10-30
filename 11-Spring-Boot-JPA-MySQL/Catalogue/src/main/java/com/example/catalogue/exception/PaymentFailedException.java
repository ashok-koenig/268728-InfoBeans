package com.example.catalogue.exception;

public class PaymentFailedException extends RuntimeException {
    public PaymentFailedException(Long id) {
        super("Payment for course "+ id + " failed");
    }
}
