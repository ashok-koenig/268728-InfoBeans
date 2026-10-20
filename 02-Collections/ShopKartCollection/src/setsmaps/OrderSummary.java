package setsmaps;

import model.Money;

public record OrderSummary(String id,
                           Customer customer,
                           Money total) {
}
