package functional;

@FunctionalInterface
public interface DiscountRule {
    double apply(double price);
}
