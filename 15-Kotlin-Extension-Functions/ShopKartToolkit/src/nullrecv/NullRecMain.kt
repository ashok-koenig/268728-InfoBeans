package nullrecv

import java.time.DayOfWeek
import java.time.LocalDate

fun String?.orDash(): String = if(this.isNullOrBlank()) "-" else this

fun String.slugify(): String =
    trim().lowercase().replace(" ", "-").trim('-')

val LocalDate.isWeekend: Boolean
    get() = dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY

fun main() {
    val note: String? = null
    println(note.orDash())
    println("Hello".orDash())
    println(note?.slugify())
    println("testing slugify".slugify())

    println(LocalDate.of(2026, 11, 4).isWeekend)
    println(LocalDate.of(2026, 11, 7).isWeekend)

}