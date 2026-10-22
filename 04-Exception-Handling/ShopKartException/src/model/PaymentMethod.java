package model;

public sealed interface PaymentMethod permits Card, Cash, Upi {
}
