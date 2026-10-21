package functional;

//class PercentOffer implements DiscountRule{
//    private final double PER = 0.10;
//    @Override
//    public double apply(double price) {
//        return price * PER;
//    }
//}

public class Main {
    public static void main(String[] args) {
//            DiscountRule terPercentOff = new PercentOffer();
        DiscountRule terPercentOff = price -> price * 0.10;
        DiscountRule flat500Off = price -> price - 500;
        System.out.println("10% off 1000: " + terPercentOff.apply(1000));
        System.out.println("Rs.500 off 1000: " + flat500Off.apply(1000));
    }
}
