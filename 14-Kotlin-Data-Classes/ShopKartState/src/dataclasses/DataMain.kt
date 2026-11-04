package dataclasses

fun main() {
    val line = OrderLine("P2", "Mouse", 2, 799)
    println(line)
    println(line.total())

//    val same = line
    val same = OrderLine("P2", "Mouse", 2, 799)
    println(line == same)
    println(line === same)
    println(line.hashCode() == same.hashCode())

    line.note = "Gift wrap"
    println(line == same)
    println(line)
}