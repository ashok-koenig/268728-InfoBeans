package sequences

fun main() {
    println("eager: ")
    val eager = (1..6).toList()
        .filter { println("filter $it"); it % 2 == 0 }
        .map { println("map $it"); it * 10 }
        .first()
    println("result = $eager")
    println("lazy: ")
    val lazy = (1..6).asSequence()
        .filter { println("filter $it"); it % 2 == 0 }
        .map { println("map $it"); it * 10 }
        .first()
    println("result = $lazy")

    val el = listOf(1, 2, 3).map { println("map $it"); it * it }
    println(el)

    val sl = listOf(1, 2, 3).asSequence().map { println("map $it"); it * it }
    println(sl.toList())

    val squares = generateSequence(1) { it + 1 }.map { it * it }.take(5).toList()
    println(squares)

    var calls = 0;
    val counted = sequenceOf(1, 2, 3). map { calls++; it * 2 }
    println(counted.toList())
    println(counted.toList())
    println("map ran $calls times")
}