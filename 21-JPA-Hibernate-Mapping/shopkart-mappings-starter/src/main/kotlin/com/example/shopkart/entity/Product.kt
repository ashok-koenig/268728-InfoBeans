package com.example.shopkart.entity

import jakarta.persistence.AttributeOverride
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "product")
class Product(
    var sku: String,
    var name: String,
    var category: String,

    @Embedded
    @AttributeOverride(name = "amount", column = Column(name = "price_amount"))
    @AttributeOverride(name = "currency", column = Column(name = "price_currency"))
    var price: Money,
    var stock: Int
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @ManyToMany
    @JoinTable(
        name = "product_tag",
        joinColumns = [JoinColumn(name = "product_id")],
        inverseJoinColumns = [JoinColumn(name = "tag_id")]
    )
    val tags: MutableSet<Tag> = mutableSetOf()
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Product) return false

        if (sku != other.sku) return false

        return true
    }

    override fun hashCode(): Int {
        return sku.hashCode()
    }


}