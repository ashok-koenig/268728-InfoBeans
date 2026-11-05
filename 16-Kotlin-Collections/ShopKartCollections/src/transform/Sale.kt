package transform

import model.SampleData

data class Sale(
    val id: Int,
    val orderId: String,
    val currency: String,
    val region: String,
    val product: String,
    val category: String,
    val amount: Double
)

fun loadSales(): List<Sale> {
    var next =0;
    return SampleData.orders().flatMap { order ->
        order.items().map { item ->
            next++
            Sale(
                next,
                order.id,
                order.customer.name,
                order.region,
                item.product.name,
                item.product.category.name,
                item.subtotal().asDouble()
            )
        }
    }
}
