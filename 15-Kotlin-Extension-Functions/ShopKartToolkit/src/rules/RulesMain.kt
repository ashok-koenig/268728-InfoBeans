package rules

open class Payment
class UpiPayment: Payment()

fun Payment.describe() = "a payment"
fun UpiPayment.describe() = "a upi payment"

class Greeter {
    fun greet() = "hello"
}
fun Greeter.greet() = "extension"
fun Greeter.greet(name: String) = "Hello $name!"

class Account(private val balance: Int)

//fun Account.show() = balance

private fun String.internalHelper() = trim()

fun main(){
    val p: Payment = UpiPayment()
    println(p.describe())
    println(UpiPayment().describe())
    println(Greeter().greet())
    println(Greeter().greet("Asha"))
    println("     padded    ".internalHelper())
}