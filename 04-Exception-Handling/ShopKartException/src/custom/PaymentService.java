package custom;

import model.*;

public class PaymentService {
    public void charge(PaymentMethod method, Money amount){
        switch (method){
            case Card card -> {
                if(card.number().startsWith("0000")){
                    throw new PaymentDeclinedException("card is blocked", amount);
                }
                if(amount.compareTo(Money.inr("50000")) > 0){
                    throw new PaymentDeclinedException("limit exceeded", amount);
                }
            }
            case Upi upi -> {
                if(amount.compareTo(Money.inr("100000"))> 0){
                    throw new PaymentDeclinedException("UPI limit exceeded", amount);
                }
            }
            case Cash cash -> {
                if(amount.compareTo(Money.inr("20000")) > 0){
                    throw new PaymentDeclinedException("cash on delivery not allowed above Rs.20000", amount);
                }
            }
        }
    }
}
