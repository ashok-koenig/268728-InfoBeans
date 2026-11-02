package strings

fun main(){
    val name = "Asha"
    println("Hi $name , ${name.length} chars")
    println(String.format("Hi %s, %d chars", name, name.length))

    val card = """
        Name: $name
        Age: 25
    """.trimIndent()
    println(card)

    val address = """
        #Address:
        #   Line 1: 123, streat name
        #   City: Indore
        #   Country: India
    """.trimMargin("#")
    println(address)
}