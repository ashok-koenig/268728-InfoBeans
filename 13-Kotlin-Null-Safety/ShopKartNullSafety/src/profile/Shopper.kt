package profile

class DeliveryAddress(val city: String, val postcode: String?)

class Shopper(
    val id: Int,
    val name: String,
    val address: DeliveryAddress? = null,
    val phone: String? = null,
    val email: String? = null
)
