package contracts;

public interface Taxable {
    double taxRate();
    default double taxOn(double price){
        return price * taxRate();
    }
}
