package identity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Same customer id, loaded twice (say, from two screens)
        Customer first = new Customer(101, "Asha");
        Customer second = new Customer(101, "Asha");

        System.out.println(first);
        System.out.println("equals: " + first.equals(second));

        Set<Customer> uniqueCustomers = new HashSet<>();
        uniqueCustomers.add(first);
        uniqueCustomers.add(second);
        System.out.println("Unique customers: " + uniqueCustomers.size());

        Map<Customer, String> loyaltyTier = new HashMap<>();
        loyaltyTier.put(first, "GOLD");
        System.out.println("Tier lookup: " + loyaltyTier.get(second));

    }
}
