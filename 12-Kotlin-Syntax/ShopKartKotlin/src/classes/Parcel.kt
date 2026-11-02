package classes

import shipping.ShipStatus

class Parcel(val id: Long, var label: String, priorityLocal: Int = 3){
    var priority: Int = priorityLocal.coerceIn(1, 5)
        set(value) {
            field = value.coerceIn(1, 5)
        }

    var status: ShipStatus = ShipStatus.PACKED

    val isDelivered: Boolean
            get() = status == ShipStatus.DELIVERED

}