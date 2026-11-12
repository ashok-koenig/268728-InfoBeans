package com.example.enrollment.domain

import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface SeatBatchRepository: JpaRepository<SeatBatch, String> {
    fun findByCourseId(courseId: String): SeatBatch?

    // Aggregate rules

    @Transactional
    @Modifying
    @Query("update SeatBatch b set b.seatsTaken = b.seatsTaken + 1 " +
            "where b.courseId = :courseId and b.seatsTaken < b.seatsTotal")
    fun takeSeat(@Param("courseId") courseId: String): Int

    @Transactional
    @Modifying
    @Query("update SeatBatch b set b.seatsTaken = b.seatsTaken - 1 " +
            "where b.courseId = :courseId and b.seatsTaken > 0")
    fun releaseSeat(@Param("courseId") courseId: String): Int

}