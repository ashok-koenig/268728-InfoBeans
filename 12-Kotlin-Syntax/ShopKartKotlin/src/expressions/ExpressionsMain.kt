package expressions

fun priorityLabel(p: Int) = when (p) {
    5 -> "CRITICAL"
    4 -> "HIGH"
    3 -> "NORMAL"
    1, 2 -> "LOW"
    else -> "INVALID"
}

fun parsePriority(text: String) = try {
    text.trim().toInt()
}catch (e:NumberFormatException){
    3
}

fun main() {
    val delivered = true
    val badge = if(delivered) "[x]" else "[ ]"
    println(badge)
    println(priorityLabel(4))
    println(parsePriority(" 4 "))
    println(parsePriority("FOUR"))
}