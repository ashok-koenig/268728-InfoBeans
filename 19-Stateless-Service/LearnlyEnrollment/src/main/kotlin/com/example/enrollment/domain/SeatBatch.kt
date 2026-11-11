package com.example.enrollment.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class SeatBatch(
    @Id
    val batchId: String,
    val courseId: String,
    val seatsTotal: Int,
) {
    var seatsTaken: Int = 0
}