package com.example.enrollment.config

import com.example.enrollment.domain.SeatBatch
import com.example.enrollment.domain.SeatBatchRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SeatBatchSeeder(private val batches: SeatBatchRepository): CommandLineRunner {
    override fun run(vararg args: String) {
        if (batches.count() == 0L){
            batches.saveAll(
                listOf(
                    SeatBatch("b-101", "c-201", 25),
                    SeatBatch("b-102", "c-202", 2),
                    SeatBatch("b-103", "c-203", 1),
                    SeatBatch("b-104", "c-204", 15),
                )
            )
        }
    }

}