package casts

import profile.Shopper
import profile.find

fun show(x: String?){
    if(x != null){
        println(x.length)
    }
    if(x == null) return
    println(x.length)
}

fun describe(o: Any) = when(o){
    is String -> "text of length ${o.length}"
    is Int -> "number ${o + 1}"
    else -> "unknown"
}

class Box(var value: String?)

fun lengthOf(box: Box): Int {
//    if(box.value != null) return box.value.length
    val v = box.value
    if(v != null) return v.length
    return 0
}

fun lengthOf2(box: Box): Int = box.value?.length ?: 0

fun main(){
    show("Asha")
    show(null)
    println(describe("Asha"))
    println(describe(41))
    println(describe(2.5))

    println(lengthOf(Box("Asha")))
    println(lengthOf2(Box("Asha")))

    var o:Any? = find(101)
    println((o as? Shopper)?.name)
    o= "text"
    println((o as? String)?.length)

}