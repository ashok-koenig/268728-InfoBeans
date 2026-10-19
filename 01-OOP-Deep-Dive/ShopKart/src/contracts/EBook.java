package contracts;

public class EBook extends Product implements Taxable{
    protected EBook(String name, double price) {
        super(name, price);
    }

    @Override
    public String category() {
        return "Digital";
    }

    @Override
    public double taxRate() {
        return 0.05;
    }
}
