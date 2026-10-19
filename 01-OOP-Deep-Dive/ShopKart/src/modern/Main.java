package modern;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Money price = Money.inr("99.99");
        System.out.println(price);
        System.out.println(price.amount() +" "+ price.currency());

        Address home = new Address("Indore", "452001");
        Customer asha = new Customer(101, "Asha", home);
        System.out.println(asha);
        Customer ashaAgain = new Customer(101, "Asha", new Address("Indore", "452001"));
        System.out.println("equals: "+ asha.equals(ashaAgain));

        try{
            new Address(" ", "452001");
        }catch (IllegalArgumentException ex){
            System.out.println("Rejected: "+ ex.getMessage());
        }

        // Sealed + Pattern Matching switch
        List<PaymentMethod> options = List.of(
                new Card("4671266676767"), new Upi("asha@upi"), new Cash(), new Wallet("PayTM")
        );

        Money bill = Money.inr("1000");
        for(PaymentMethod option: options){
            System.out.println(PaymentRules.describe(option)
                    + " -> gateway fee " + PaymentRules.gatewayFee(option, bill).amount());
        }
    }
}
