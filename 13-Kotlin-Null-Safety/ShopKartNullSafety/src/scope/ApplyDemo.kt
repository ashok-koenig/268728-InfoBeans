package scope

fun main() {
    val john = Person().apply {
        name = "John"
        age = 19
    }

    println(john)
}