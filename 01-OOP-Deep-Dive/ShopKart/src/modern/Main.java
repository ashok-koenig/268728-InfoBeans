package modern;

public class Main {
    public static void main(String[] args) {
        Money price = Money.inr("99.99");
        System.out.println(price);
        System.out.println(price.amount() +" "+ price.currency());

        Address home = new Address("Indore", "452001");
        Customer asha = new Customer(101, "Asha", home);
        System.out.println(asha);
        Customer ashaAgain = new Customer(101, "Asha", new Address("Indore", "452001"));
        System.out.println("equals: "+ asha.equals(ashaAgain));

        try{
            new Address(" ", "452001");
        }catch (IllegalArgumentException ex){
            System.out.println("Rejected: "+ ex.getMessage());
        }
    }
}
