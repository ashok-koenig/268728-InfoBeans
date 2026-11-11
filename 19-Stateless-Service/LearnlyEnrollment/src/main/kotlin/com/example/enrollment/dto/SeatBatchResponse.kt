package com.example.enrollment.dto

import com.example.enrollment.domain.SeatBatch

data class SeatBatchResponse(val courseId: String,
                             val seatsTotal: Int,
                             val seatsTaken: Int,
                             val seatsLeft: Int)

fun SeatBatch.toResponse() = SeatBatchResponse(courseId, seatsTotal, seatsTaken, seatsTotal - seatsTaken)
