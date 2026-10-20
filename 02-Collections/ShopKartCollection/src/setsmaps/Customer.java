package setsmaps;

import java.util.Objects;

public class Customer {
    private final long id;
    private final String name;

    public Customer(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Customer customer)) return false;
        return id == customer.id && Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return name;
    }
}
