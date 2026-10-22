package custom;

import model.Card;
import model.SampleData;
import model.Upi;

public class Main {
    public static void main(String[] args) {
        InventoryService inventory = new InventoryService();
        OrderService service = new OrderService(inventory, new PaymentService());
        System.out.println(service.place("N-1001", SampleData.ASHA, SampleData.LAPTOP, 1, new Upi("asha@upi")));
        try{
            service.place("N-1002", SampleData.BOB, SampleData.LAPTOP, 5, new Upi("bob@upi"));
        }catch (InsufficientStockException e){
            System.out.println(e.getMessage() + ":" + e.getAvailable() + " left, requested: "+ e.getRequested());
        }

        try{
            service.place("N-1003", SampleData.CHITRA, SampleData.LAPTOP, 1, new Card("411111111111123"));
        }catch (PaymentDeclinedException e){
            System.out.println("Ask for another payment method. " + e.getMessage() + " (" + e.getAmount() + ")");
            System.out.println("Stock restored: "+ inventory.available(SampleData.LAPTOP));
        } catch (ShopException e){
            System.out.println("Something else went wrong in the shop: "+ e.getMessage());
        }

        try{
            System.out.println("Found: "+ service.find("O1").id());
            service.find("O77");
        }catch (PaymentDeclinedException e){
            System.out.println("not this one");
        } catch (ShopException e){
            System.out.println("Family handler:  "+ e.getMessage() + "(" + e.getClass().getSimpleName()+")");
        }
    }
}
