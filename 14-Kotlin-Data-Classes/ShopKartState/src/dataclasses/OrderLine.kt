package dataclasses

data class OrderLine(val sku: String,
                     val name: String,
                     val qty: Int,
                     val unitPrice: Int){

    var note: String = ""

    fun total() = qty * unitPrice
}
