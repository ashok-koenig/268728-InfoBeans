package creating

fun main(){
    val names = listOf("Asha", "Chitra", "Meena")
    val upper = names.filter { it.length > 4 }.map { it.uppercase() }
    println(upper)

    val tags = setOf("Kotlin", "Java", "Kotlin")
    println(tags)

    val stock = mapOf("Pen" to 10, "Book" to 20)
    println(stock)

    println(names[0])
    println(stock["Pen"])
    println(stock["Laptop"] ?: 0)
    println(stock.getOrDefault("Laptop", 0))

    val log = mutableListOf("Start")
    log.add("loaded")
    log += "done"
    println(log)

    val counts = mutableMapOf("a" to 1)
    counts["b"] = 2
    println(counts["a"])
    println(counts)

    val squares = buildList {
        for(i in 1..5) add(i * i)
    }
    println(squares)

    val a = listOf(1, 2, 3)
//    a += 4
    val b = a + 4
    val c = b - 1
    println("$a, $b, $c")

    var d = listOf(1, 2, 3)
    d += 4
    println(d)

    val e = mutableListOf("a", "b", "c")
    e += "d"
    println(e)
}