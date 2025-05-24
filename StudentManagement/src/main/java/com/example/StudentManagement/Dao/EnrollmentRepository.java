package com.example.StudentManagement.Dao;

import com.example.StudentManagement.models.Course;
import com.example.StudentManagement.models.Enrollment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Integer> {
    boolean existsByStudentIdAndCourseId(int studentId, int courseId);
    @Query("SELECT e.course.name FROM Enrollment e WHERE e.student.id = :studentId")
    List<String> findCourseNamesByStudentId(@Param("studentId") int studentId);

    /// /this is performs inner join between courses and enrollment table by courseId to get the name
    @Query("SELECT e.student.name FROM Enrollment e WHERE e.course.id = :courseId")
    List<String> findStudentNamesByCourseId(@Param("courseId") int courseId);

    @Transactional
    void deleteByStudentIdAndCourseId(int studentId, int courseId);

}
