package extensions

fun String.shout(): String = uppercase() + "!"

fun String.truncate(max: Int, ellipsis: String = "..."): String =
    if (length <= max) this else take(max) + ellipsis