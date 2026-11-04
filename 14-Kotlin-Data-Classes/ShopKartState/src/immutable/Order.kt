package immutable

import dataclasses.OrderLine
import enums.OrderStatus

data class Order(
    val id: String,
    val customer: String,
    val status: OrderStatus = OrderStatus.PLACED,
    val lines: List<OrderLine> = emptyList()
){
    fun ship() = copy(status = OrderStatus.SHIPPED)
    fun deliver() = copy(status = OrderStatus.DELIVERED)
}
