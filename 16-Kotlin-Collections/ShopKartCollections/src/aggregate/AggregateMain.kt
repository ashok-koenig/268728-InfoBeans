package aggregate

import transform.loadSales

fun main() {
    val sales = loadSales()
    val amounts = sales.map { it.amount }
    println(amounts.sum())

    println(sales.sumOf{ it.amount})
    println(sales.count())
    println(sales.size)
    println(sales.count { it .category == "STATIONERY"})

    println(sales.fold(0.0) { acc, s -> acc + s.amount })
    println(amounts.reduce { acc, amount -> amount + acc })

    val xs = listOf(3, 1, 4)
    println(xs.fold(10) { acc, x -> acc + x })
    println(xs.reduce { acc, x -> acc + x })

    println(emptyList<Int>().fold(10) { acc, x -> acc + x })
    println(emptyList<Int>().reduceOrNull { acc, x -> acc + x })

    val biggest = sales.maxByOrNull { it.amount }
    println(biggest?.product + ": " + biggest?.amount)

    println(emptyList<Double>().maxOrNull())

    println(sales.minByOrNull {it.amount}?.product)

    println(sales.sortedByDescending { it.amount}.take(3).map { it.product })
}