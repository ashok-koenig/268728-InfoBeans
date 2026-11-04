package values

@JvmInline
value class OrderId(val value: Long)

@JvmInline
value class ProductId(val value: Long){
    init {
        require(value >= 0L) {"product id must be positive"}
    }
}
