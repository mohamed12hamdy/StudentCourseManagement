package com.example.StudentManagement.Dao;

import com.example.StudentManagement.models.Course;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface CourseRepository extends JpaRepository<Course, Integer> {

    Optional<Course>findByName(String name);
}
