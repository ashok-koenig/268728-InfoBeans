package modern;

public sealed interface PaymentMethod permits Card, Cash, Upi, Wallet {
}
