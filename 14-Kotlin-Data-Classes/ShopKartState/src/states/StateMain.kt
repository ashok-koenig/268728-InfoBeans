package states

import enums.OrderStatus
import java.time.LocalDate

fun describe(state: Delivery): String = when (state) {
    is Delivery.Placed -> "waiting"
    is Delivery.Shipped -> "on the way, tracking ${state.tracking}"
    is Delivery.OnHold -> "on hold: ${state.reason}"
    is Delivery.Delivered -> "delivered on ${state.on}"
//    else -> "unknown"
}

fun main(){
//    val broken = OrderRecord(OrderStatus.DELIVERED, null, null)
//    println(broken)
    val states = listOf(
        Delivery.Placed,
        Delivery.Shipped("TRK-1001"),
        Delivery.OnHold("address unclear"),
        Delivery.Delivered(LocalDate.of(2026, 11, 4))
    )
    for(state in states){
        println(describe(state))
    }

    val shipment = Shipment(1)
    println(describe(shipment.delivery))
    val onTheWay = shipment.ship("TRK-1002")
    println(describe(onTheWay.delivery))
    val held = onTheWay.hold("customer not home")
    println(describe(held.delivery))
    val done = held.deliver(LocalDate.of(2026, 11, 4))
    println(describe(done.delivery))
}