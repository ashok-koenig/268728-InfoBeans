package states

import enums.OrderStatus

fun main(){
    val broken = OrderRecord(OrderStatus.DELIVERED, null, null)
    println(broken)
}