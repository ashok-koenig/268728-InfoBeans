package shipping;

import java.util.Objects;

// The kind of class a Week 2 Java project has: fields, a constructor, getters and setters
public class Shipment {
    private long id;
    private String label;
    private String description;
    private ShipStatus status;
    private int priority;
    private String category;

    public Shipment(long id, String label, String description, ShipStatus status, int priority, String category) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ShipStatus getStatus() {
        return status;
    }

    public void setStatus(ShipStatus status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Shipment other = (Shipment) o;
        return id == other.id && priority == other.priority && Objects.equals(label, other.label)
                && Objects.equals(description, other.description) && status == other.status
                && Objects.equals(category, other.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label, description, status, priority, category);
    }

    @Override
    public String toString() {
        return "Shipment{id=" + id + ", label=" + label + ", status=" + status + ", priority=" + priority + "}";
    }
}
