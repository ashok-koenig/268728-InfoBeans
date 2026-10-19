package contracts;

public interface Notifier {
    String customerName();

    default String confirmation(String orderId){
        return decorate("Hi, "+ customerName() + ", order "+ orderId + " is confirmed");
    }

    static Notifier of(String customerName){
        return () -> customerName;
    }

    private String decorate(String message){
        return "*** " + message + " ***";
    }
}
