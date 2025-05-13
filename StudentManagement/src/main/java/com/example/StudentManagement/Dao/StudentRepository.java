package com.example.StudentManagement.Dao;

import com.example.StudentManagement.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository  extends JpaRepository<Student,Integer> {
}
