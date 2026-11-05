package views

fun main(){
    val backing = mutableListOf(1, 2, 3)
    val view: List<Int> = backing

    backing.add(4)
    println(view)

//    view.add(5)
    (view as MutableList<Int>).add(5)
    println(backing)

    val copy = backing.toList()
    backing.add(6)
    println(copy)
    println(backing)

    val readOnly: List<Int> = listOf(1, 2, 3)
//    readOnly.add(4) // not possible

    val cart = Cart()
    cart.add("Laptop")
    val seen = cart.items
    val frozen = cart.snapshot
    cart.add("Mouse")
    println("cart: ${cart.items}")
    println("seen: $seen")
    println("frozen: $frozen")
}

class Cart {
    private val _items = mutableListOf<String>()

    val items: List<String>
        get() = _items

    val snapshot: List<String>
        get() = _items.toList()

    fun add(item: String) {
        _items.add(item)
    }
}