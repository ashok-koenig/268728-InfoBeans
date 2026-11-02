package basics

fun main() {
    val shop = "ShopKart"
    var orders = 0
    orders = orders + 1
//    orders++
    println(shop + " has " + orders + " orders today")
//    shop = "OtherShop" // not possible

    val price = 799L // implicit type - type inference
    val discount: Double = 0.20 // explicit type
    val total: Double = price * discount
    println("Total cost: " + total)
    println( 7 / 2)
    println(7 / 2.0)
}