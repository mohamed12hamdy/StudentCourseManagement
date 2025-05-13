package com.example.StudentManagement.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "studentId", referencedColumnName = "Id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "courseId", referencedColumnName = "Id", nullable = false)
    private Course course;

    private double Grade;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;

}
