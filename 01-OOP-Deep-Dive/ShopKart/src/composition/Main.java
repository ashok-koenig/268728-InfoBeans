package composition;

public class Main {
    public static void main(String[] args) {
        // Inheritance: every new combination needs a new subclass
        System.out.println("Basic        : " + new BasicOrder(400).total());
        System.out.println("Express      : " + new ExpressOrder(400).total());
        System.out.println("Gift         : " + new GiftOrder(400).total());
        System.out.println("Express+Gift : " + new ExpressGiftOrder(400).total());

        // Composition: one Order, parts are plugged in
        Order plain = new Order("ORD-1", 400, new StandardShipping(), new NoGift());
        Order fancy = new Order("ORD-2", 400, new ExpressShipping(), new GiftWrap());
        System.out.println("Plain total  : " + plain.total());
        System.out.println("Fancy total  : " + fancy.total());

    }
}
