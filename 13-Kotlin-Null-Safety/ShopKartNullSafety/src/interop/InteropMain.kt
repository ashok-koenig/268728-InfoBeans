package interop

fun main() {
    val legacy = LegacyName()
    val name: String? = legacy.findName(105)
    println(name)
    println(name?.length)

    val annotatedName = AnnotatedName()
    val name1 = annotatedName.findName(101)
    println(name1)
    println(name1?.length)
    val message = annotatedName.greeting("Asha");
    println(message)
    println(message.length)
}