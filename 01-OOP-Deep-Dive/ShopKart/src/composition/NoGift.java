package composition;

public class NoGift implements GiftOption{
    @Override
    public double fee() {
        return 0;
    }
}
