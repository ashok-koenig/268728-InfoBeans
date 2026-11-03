package assertion

import profile.Shopper
import profile.find

fun main(){
    val shopper: Shopper? = find(104)
    try {
        val city = shopper!!.address!!.city
        println(city)
    }catch (e: NullPointerException){
        println(e.message)
    }

    println(shopper?.address?.city ?: "Unknown")
    if(shopper != null){
        println(shopper.name)
    }
    val asha = requireNotNull(find(101)) { "Shopper is null" }
    println(asha.name)
}