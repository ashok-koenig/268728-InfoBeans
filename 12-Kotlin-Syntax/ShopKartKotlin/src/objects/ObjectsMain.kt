package objects

import classes.Parcel
import objects.Voucher.Companion.student

fun main(){
    println(IdGenerator.next())
    println(IdGenerator.next())
    val parcel = Parcel(IdGenerator.next(), "Desk for bob")
    println(parcel.id)

    println(Voucher.welcome().code)
    println(Voucher.student().code)
    println(Voucher.MAX_PERCENT)

    println(SHOP_NAME)
    println(isValidPercent(10))
    println(isValidPercent(60))
}