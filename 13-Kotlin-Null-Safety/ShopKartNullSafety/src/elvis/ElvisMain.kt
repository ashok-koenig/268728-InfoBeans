package elvis

import profile.Shopper
import profile.find

fun lengthOf(name: String?): Int  = name?.length ?: 0

fun label(id: Int): String {
    val shopper = find(id) ?: return "Unknown"
    val address = shopper.address ?: return "no address"
    return "${shopper.name}, ${address.city}"
}

fun mustFind(id: Int): Shopper = find(id) ?: throw IllegalArgumentException("No shopper found for id $id")

fun mustFind2(id: Int): Shopper = requireNotNull(find(id)) { "No shopper found for id $id" }

fun main() {
    val shopper = find(104)
    val city = shopper?.address?.city ?: "no city"
    println(city)
    println(lengthOf("Asha"))
    println(lengthOf(null))
    println(label(101))
    println(label(104))
    println(label(999))

    println(mustFind(101).name)
    try {
        println(mustFind(999))
    }catch (e: IllegalArgumentException) {
        println(e.message)
    }
    try {
        println(mustFind2(999))
    }catch (e: IllegalArgumentException) {
        println(e.message)
    }
}