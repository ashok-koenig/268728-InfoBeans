package streams

import legacy.ShopStreams
import model.SampleData

fun main() {
    val orders = SampleData.orders()
    println(ShopStreams.revenueByRegion(orders))

    val byRegion = orders.groupBy { it.region }
        .mapValues { (_, list) -> list.sumOf {it.totalAmount()} }.toSortedMap()
    println(byRegion)
}