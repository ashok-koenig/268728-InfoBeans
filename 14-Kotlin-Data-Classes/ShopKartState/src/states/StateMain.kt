package states

import enums.OrderStatus
import java.time.LocalDate

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
        println(state)
    }
}