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

    var note: String
        private set

    init {
        println("Primary constructor init block works")
        require(label.isNotBlank()) { "label cannot be blank" }
        note = "Sample note"
    }
    constructor(label: String) : this (0, label){
        println("Secondary constructor works - with label")
    }
    constructor(id: Long) : this (id, "Sample Parcel"){
        println("Secondary constructor works - with id")
    }



    internal fun debugInfo() = "Parcel " + id
}