package safecall

import profile.find

fun postCodeOf(id: Int): String ? = find(id)?.address?.postcode

fun main(){
    val shopper = find(101)
    val name: String? = shopper?.name
    println(name)
    println(find(999)?.name)

    val city: String? = find(102)?.address?.city
    println(city)
    val noAddress: String? = find(104)?.address?.city
    println(noAddress)
    val digits: Int? = shopper?.phone?.length
    println(digits)
    println(postCodeOf(101))
    println(postCodeOf(104))
    println(postCodeOf(999))
}