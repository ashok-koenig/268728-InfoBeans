package com.example.enrollment.domain

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface EnrollmentRepository : JpaRepository<Enrollment, Long> {

    fun findByStudentId(studentId: String, pageable: Pageable): Page<Enrollment>

    fun existsByStudentIdAndCourseIdAndStatus(studentId: String, courseId: String, status: EnrollmentStatus): Boolean

    fun existsByStudentIdAndCourseIdAndStatusIn(studentId: String, courseId: String,
                                                statuses: Collection<EnrollmentStatus>): Boolean
}