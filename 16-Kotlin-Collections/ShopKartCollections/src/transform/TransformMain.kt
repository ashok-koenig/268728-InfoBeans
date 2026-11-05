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
}