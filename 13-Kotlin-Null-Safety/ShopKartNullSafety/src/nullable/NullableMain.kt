package nullable

fun lengthOf(text: String?): Int? = text?.length

fun main() {
    var name: String = "Asha"
    println(name + ": "+ name.length + " chars" )
//    name = null // not possible
    var nickname: String? = "Ash"
    println(nickname + ": "+ lengthOf(nickname) + " chars")
    nickname = null
    println(nickname + ": " + lengthOf(nickname) + " chars")
}