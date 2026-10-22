package checked;

// Unchecked
public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(String id){
        super("No order with id "+ id);
    }
}
