package states

import enums.OrderStatus
import java.time.LocalDate

data class OrderRecord(
    val status: OrderStatus,
    val tracking: String?,
    val deliveredOn: LocalDate?
)
