package loops

fun main() {
    for(i in 1..3){
        println("item "+i)
    }
    for (i in 1 until 3){
        println("item "+i)
    }
    for (i in 10 downTo 0 step 5){
        println("item "+i)
    }

    var i = 0
    while(i<3){
        println("item "+i)
        i++
    }
}