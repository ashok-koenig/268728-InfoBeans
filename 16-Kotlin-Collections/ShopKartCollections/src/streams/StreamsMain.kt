package streams

import legacy.ShopStreams
import legacy.TagService
import model.SampleData
import kotlin.streams.asSequence

fun main() {
    val orders = SampleData.orders()
    println(ShopStreams.revenueByRegion(orders))

    val byRegion = orders.groupBy { it.region }
        .mapValues { (_, list) -> list.sumOf {it.totalAmount()} }.toSortedMap()
    println(byRegion)

    val stream = SampleData.orders().stream()
    println(stream.count())
    try{
        println(stream.count())
    } catch (e: IllegalStateException){
        println(e.message)
    }

    val list = TagService.tagStream().toList()
    println(list)

    val seq = TagService.tagStream().asSequence()
    println(seq.map { it.length }.toList())

    var names = listOf("Asha", "Chitra", "Meena")
    val st1 = names.stream()
    val st2 = names.asSequence()
    println(st1.count())
    println(st2.count())

    println(TagService.totalLength(names))
    try{
        TagService.addDefault(names)
    } catch (e: UnsupportedOperationException){
        println(e.javaClass.simpleName)
    }
    val growable = names.toMutableList()
    TagService.addDefault(growable)
    println(growable)

}