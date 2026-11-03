package scope

import profile.find

fun main() {
    val asha = find(101) ?: return

    asha.phone?.let { println("calling $it") }

    val digits = asha.phone?.let { p -> p.count { c -> c.isDigit()}}
    println(digits)

    val summary = asha.run {
        "$name lives in ${address?.city ?: "Unknown"}"
    }
    println(summary)
}