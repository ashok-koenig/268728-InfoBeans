package setup

import model.SampleData
import shipping.ShipStatus
import shipping.Shipment

fun main(){
    println("Hello from Kotlin!")

    for(product in SampleData.products()){
        println(product.name + " costs " + product.price)
    }

    val shipment = Shipment(1, "Laptop for Asha", "",
        ShipStatus.PACKED, 3, "Electronics")

    shipment.status = ShipStatus.SHIPPED

    println(shipment.label + " is " + shipment.status)

}