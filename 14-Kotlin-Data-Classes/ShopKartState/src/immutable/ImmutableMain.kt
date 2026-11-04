package immutable

import enums.OrderStatus

fun main() {
    val original = Order("01", "Asha")
//    val shipped = original.copy(status = OrderStatus.SHIPPED)
    val shipped = original.ship()
    println(original.status)
    println(shipped.status)
    println(shipped)
    val delivered = shipped.deliver()
    println(delivered.status)
    println(delivered)

    val a = Basket("Asha", mutableListOf("Mouse"))
    val b = a.copy(owner = "Bob")
    b.items.add("Pen")
    println(a)
    println(b)
}