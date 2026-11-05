package transform

fun main() {
    val nums = listOf(1, 2, 3, 4, 5)
    println(nums.map { it * 10})
    println(nums.filter { it % 2 == 0})
    println(nums.filter { it % 2 == 0}.map { it * 10})

    val orders = listOf (
        listOf(1, 2, 3),
        listOf(4, 5),
        listOf(6, 7, 1),
    )
    println(orders)
    println(orders.flatten())
    println(orders.flatMap {it }.distinct())

    val sales = loadSales()
    println(sales.size)
//    println(sales.first())
    for (sale in sales) {
        println(sale)
    }

    val byId = sales.associateBy { it.id }
    println(byId[3]?.product)
    val names = sales.associate { it.id to it.product }
    println(names)
    println(names[3])

    val byCategory = sales.groupBy { it.category }
    println(byCategory["ELECTRONICS"])

    val totals = byCategory.mapValues { (_, items) -> items.sumOf { it.amount } }
    println(totals)

    println(sales.groupingBy { it.category }.eachCount())

    val (big, small ) = sales.partition { it.amount >=5000 }
    println(big.map { it.product })
    println(small.map { it.product })
}