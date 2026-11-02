package classes

import shipping.ShipStatus

fun main() {
    val parcel = Parcel(1, "Laptop for Asha")
    println (parcel.id.toString() + " " + parcel.label)
    parcel.label = "Laptop for Asha (gift)"
    println (parcel.id.toString() + " " + parcel.label)
    println(parcel.priority)
    parcel.priority = 4
    println(parcel.priority)

    parcel.status = ShipStatus.DELIVERED
    println("Delivered: " + parcel.isDelivered)
}