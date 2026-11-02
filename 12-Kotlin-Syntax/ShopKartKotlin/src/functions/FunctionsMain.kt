package functions

//fun add(a: Int, b: Int): Int {
//    return a + b
//}

fun add(a: Int, b: Int) = a + b

fun greet(name: String) {
    println("Hi " + name)
}

fun row(name: String, price: Int, width: Int = 12, rupee: Boolean = false): String {
    val shown  = if (rupee) "Rs " + price else price.toString()
    return name.padEnd(width, ' ') + shown
}

fun gst(price: Int ) = price * 18 / 100

fun stockLabel(qty: Int ) = if(qty > 0) "In stock" else "Sold out"

fun main() {
    println(add(1, 2))
    greet("Asha")
    println(row("Laptop", 65000))
    println(row("Mouse", 799, 9))

    println(row("Pen", 20, rupee = true))
    println(row(price = 60, name = "Notebook", width = 10))
    println(gst(65000))
    println(stockLabel(0))
}