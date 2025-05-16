package com.example.StudentManagement.Dao;

import com.example.StudentManagement.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository  extends JpaRepository<Student,Integer> {
    Optional<Student>findByEmail(String email);
}
