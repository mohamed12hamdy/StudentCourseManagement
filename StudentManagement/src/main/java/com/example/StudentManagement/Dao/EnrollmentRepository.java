package com.example.StudentManagement.Dao;

import com.example.StudentManagement.models.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Integer> {
    boolean existsByStudentIdAndCourseId(int studentId, int courseId);
}
