package states

import java.time.LocalDate

sealed interface Delivery {
    data object Placed: Delivery
    data class Shipped(val tracking: String): Delivery
    data class OnHold(val reason: String): Delivery
    data class Delivered(val on: LocalDate): Delivery
}