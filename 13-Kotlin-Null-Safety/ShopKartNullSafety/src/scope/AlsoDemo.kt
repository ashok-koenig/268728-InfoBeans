package scope

fun main() {
    val person = Person("John", 18)
    val personWithDebug = person
                    .also { println("Original person: $it") }
                    .apply { name = "John smith" }
                    .also { println("After Update person: $it") }
    println(personWithDebug)
}