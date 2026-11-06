package com.example.catalogue.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "reviews")
class Review(
    @Column(nullable = false)
    var courseId: Long,
    @Column(nullable = false)
    var rating: Int,
    @Column(name="comment_text", nullable = false, length = 500)
    var comment: String,
    @Column(nullable = false, length = 60)
    var reviewer: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}