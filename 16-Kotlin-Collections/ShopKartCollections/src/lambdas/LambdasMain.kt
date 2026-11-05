package lambdas

val add: (Int, Int) -> Int = { a , b ->
    val result = a + b
    result
}
val twice: (Int) -> Int = { it * 2} // { a -> a * 2}

val action: () -> Unit = { println("Hello") }

val length: (String) -> Int = String::length // {it -> it.length)

fun main(){
    println(add(1, 2))
    println(twice(4))
    action()
    println(length("Hello"))
}