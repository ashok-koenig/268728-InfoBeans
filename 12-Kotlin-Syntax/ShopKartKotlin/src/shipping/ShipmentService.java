package shipping;

import java.util.ArrayList;
import java.util.List;

// Week 2 style service: loops, if-else chains, a switch and string concatenation
public class ShipmentService {
    private final List<Shipment> shipments = new ArrayList<>();

    public void add(Shipment shipment) {
        shipments.add(shipment);
    }

    public List<Shipment> all() {
        return shipments;
    }

    public long countDelivered() {
        long count = 0;
        for (Shipment s : shipments) {
            if (s.getStatus() == ShipStatus.DELIVERED) {
                count++;
            }
        }
        return count;
    }

    public String format(Shipment s) {
        return "#" + s.getId() + " " + s.getLabel() + " [" + s.getStatus() + "]";
    }

    public String priorityLabel(int priority) {
        if (priority == 5) {
            return "CRITICAL";
        } else if (priority == 4) {
            return "HIGH";
        } else if (priority == 3) {
            return "NORMAL";
        } else if (priority == 1 || priority == 2) {
            return "LOW";
        } else {
            return "INVALID";
        }
    }

    public String statusLabel(ShipStatus status) {
        switch (status) {
            case PACKED:
                return "Waiting in the warehouse";
            case SHIPPED:
                return "On the way";
            case DELIVERED:
                return "At the customer";
            default:
                return "Unknown";
        }
    }

    public int parsePriority(String text) {
        int priority;
        try {
            priority = Integer.parseInt(text.trim());
        } catch (NumberFormatException e) {
            priority = 3;
        }
        return priority;
    }
}
