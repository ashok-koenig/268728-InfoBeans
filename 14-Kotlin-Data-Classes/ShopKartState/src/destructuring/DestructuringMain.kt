package destructuring

import dataclasses.OrderLine

fun main() {
    val line = OrderLine("P1", "Laptop", 1, 65000)
    println(line.component1())
    println(line.component2())

    val (sku, title, qty) = line
    println("$sku, $title, $qty")

    val(_, _, _, price) = line
    println(price)

//    val xy = Pair(100, 200)
    val xy = "pen" to 200
    println(xy)
    println(xy.first)
    println(xy.second)
    val (x, y) = xy
    println(x)
    println(y)

    val xyz = Triple(100, 200, 300)
    println(xyz)
    println(xyz.third)
    val (_, _ , z) = xyz
    println(z)

    val prices = mapOf("pen" to 20, "notebook" to 60)
    for ((item, price) in prices) {
        println("$item -> $price")
    }

    val (big, small ) = listOf(5, 7, 2, 9).partition { it > 5 }
    println(big)
    println(small)
}