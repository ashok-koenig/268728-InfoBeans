package model;

// Products are numbered, so their natural order is by id
public record Product(int id, String name, Category category, Money price) implements Comparable<Product> {

    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.id, other.id);
    }
}
