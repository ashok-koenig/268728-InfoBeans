package model;

public sealed interface PaymentMethod permits Card, Upi, Cash {
}
