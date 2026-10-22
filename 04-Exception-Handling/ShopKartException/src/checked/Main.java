package checked;

import model.Order;
import model.SampleData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    // checked
    static String readReceipt(String file) throws IOException {
        return Files.readString(Path.of(file));
    }
    // unchecked: no throws needed
    static String findOrder(String id){
        for (Order order: SampleData.orders()){
            if(order.id().equals(id)){
                return "Order "+ order.id() +": "+ order.customer().name() + ", "+ order.total();
            }
        }
        throw new OrderNotFoundException(id);
    }
    public static void main(String[] args)  {
        try {
            System.out.println(readReceipt("missing-receipt.txt"));
        } catch (IOException e) {
            System.out.println("Receipt not available, Exception: "+ e.getClass().getSimpleName());
        }
        try {
            System.out.println(findOrder("O1"));
            System.out.println(findOrder("O7"));
        }catch (OrderNotFoundException e){
            System.out.println("Unchecked Exception: "+ e.getMessage());
        }

        System.out.println("The End");
    }
}
