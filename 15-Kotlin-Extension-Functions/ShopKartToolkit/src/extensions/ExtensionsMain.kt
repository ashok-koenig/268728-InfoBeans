package extensions

import kotlin.text.Typography.ellipsis

fun main() {
    val title = "Kotlin Extensions for ShopKart"
    println(title)
    println(title.shout())
    println(title.truncate(10))
}