package objects

import classes.Parcel

fun main(){
    println(IdGenerator.next())
    println(IdGenerator.next())
    val parcel = Parcel(IdGenerator.next(), "Desk for bob")
    println(parcel.id)
}