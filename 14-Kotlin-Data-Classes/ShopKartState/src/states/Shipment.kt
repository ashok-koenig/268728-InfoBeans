package states

import java.time.LocalDate

data class Shipment(
    val id: Long,
    val delivery: Delivery = Delivery.Placed
){
    fun ship(tracking: String) = copy(delivery = Delivery.Shipped(tracking))
    fun hold(reason: String) = copy(delivery = Delivery.OnHold(reason))
    fun deliver(on: LocalDate) = copy(delivery = Delivery.Delivered(on))
}

