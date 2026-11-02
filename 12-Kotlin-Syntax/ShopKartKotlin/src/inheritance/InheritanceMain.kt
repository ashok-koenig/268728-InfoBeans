package inheritance

open class Payment(val amount: Int) {
    open fun label() = "Payment of Rs " + amount
}

class UpiPayment(amount: Int, val handle: String) : Payment(amount){
    override fun label() = "UPI " + handle + ":"+ super.label()
}

interface Shippable {
    fun shippingLabel(): String
    fun fee() = 0
}

class Delivery(val city: String): Shippable {
    override fun shippingLabel() = "Delivery to " + city
}

abstract class Courier {
    abstract fun cost(km: Int): Int
    fun quote(km: Int) = "Rs "+ cost(km)
}

class BikeCourier: Courier() {
    override fun cost(km: Int) = km * 10
}

fun main() {
    println(Payment(500).label())
    val p: Payment = UpiPayment(600, "asha@upi")
    println(p.label())

    val delivery = Delivery("Indore")
    println(delivery.shippingLabel())
    println(delivery.fee())
    println(BikeCourier().quote(5))
}