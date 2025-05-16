package com.example.StudentManagement.Dao;

import com.example.StudentManagement.models.Course;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CourseRepository extends JpaRepository<Course, Integer> {
}
