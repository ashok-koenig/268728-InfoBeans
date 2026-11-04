package enums

fun main() {
    val s = OrderStatus.PLACED
    println(s.name)
    println(s.ordinal)
    println(OrderStatus.valueOf("SHIPPED"))
    println(OrderStatus.entries)
//    println(OrderStatus.values().toList())

    try{
        OrderStatus.valueOf("HOLD")
    } catch(e: IllegalArgumentException){
        println(e.message)
    }
}