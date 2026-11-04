package values

fun addToCart(orderId: OrderId, productId: ProductId) {
    println("order $orderId gets product $productId")
}

fun main() {
//    val orderId = 5L
//    val productId = 15L
//    addToCart(orderId, productId)
//    addToCart(productId, orderId)
    val orderId = OrderId(5)
    val productId = ProductId(15)
    addToCart(orderId, productId)
//    addToCart(productId, orderId)
//    addToCart(15L, 5L)
}