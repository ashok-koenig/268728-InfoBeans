package com.example.enrollment.application

import com.example.enrollment.domain.Enrollment
import com.example.enrollment.domain.EnrollmentRepository
import com.example.enrollment.domain.EnrollmentStatus
import com.example.enrollment.domain.SeatBatch
import com.example.enrollment.domain.SeatBatchRepository
import com.example.enrollment.exception.BusinessException
import com.example.enrollment.exception.ErrorKind
import org.springframework.boot.web.error.Error
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class EnrollmentApplicationService(
    private val seats: SeatBatchRepository,
    private val enrollmentRepository: EnrollmentRepository
) {

    fun seatsOf(courseId: String): SeatBatch = seats.findByCourseId(courseId)
        ?: throw BusinessException(ErrorKind.NOT_FOUND, "Course not found", "No seats are kept for course $courseId")

    fun enroll(studentId: String, courseId: String): Enrollment {
        if (seats.findByCourseId(courseId) == null) {
            throw BusinessException(ErrorKind.NOT_FOUND, "Course not found", "No seats are kept for course $courseId")
        }
        if (enrollmentRepository
                .existsByStudentIdAndCourseIdAndStatus(studentId, courseId, EnrollmentStatus.CONFIRMED)
        ) {
            throw BusinessException(
                ErrorKind.CONFLICT,
                "Already enrolled",
                "$studentId is already enrolled in $courseId"
            )
        }
        if (seats.takeSeat(courseId) == 0) {
            throw BusinessException(ErrorKind.CONFLICT, "No seats left", "Course $courseId is full")
        }
        try {
            return enrollmentRepository.save(Enrollment(studentId, courseId))
        } catch (e: RuntimeException) {
            seats.releaseSeat(courseId)
            throw e;
        }
    }

    fun find(id: Long, studentId: String, admin: Boolean): Enrollment {
        val enrollment = enrollmentRepository.findById(id)
            .orElseThrow { BusinessException(ErrorKind.NOT_FOUND, "Enrollment not found", "No enrollment with id $id") }
        if(enrollment.studentId != studentId && !admin) {
            throw BusinessException(ErrorKind.FORBIDDEN, "Forbidden", "This enrollment belongs to another student")
        }
        return enrollment
    }

    fun listOf(studentId: String, pageable: Pageable): Page<Enrollment>
                = enrollmentRepository.findByStudentId(studentId, pageable)

    fun cancel(id: Long, studentId: String, admin: Boolean){
        val enrollment = find(id, studentId, admin)
        if(enrollment.cancel()){
            enrollmentRepository.save(enrollment)
            seats.releaseSeat(enrollment.courseId)
        }
    }
}