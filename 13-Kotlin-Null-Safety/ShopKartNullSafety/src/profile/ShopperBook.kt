package profile

// The shopper contact cards of the sample day: not every card is complete
private val shoppers = listOf(
    Shopper(101, "Asha", DeliveryAddress("Pune", "411001"), "98765 43210", "asha@shopkart.in"),
    Shopper(102, "Bob", DeliveryAddress("Mumbai", null), "99887 76655"),
    Shopper(103, "Chitra", DeliveryAddress("Pune", "411002"), null, "chitra@shopkart.in"),
    Shopper(104, "Dev"),
    Shopper(105, "Farid", DeliveryAddress("Delhi", "110002"), "91234 56789")
)

fun find(id: Int): Shopper? {
    for (shopper in shoppers) {
        if (shopper.id == id) {
            return shopper
        }
    }
    return null
}
