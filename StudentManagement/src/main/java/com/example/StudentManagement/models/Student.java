package com.example.StudentManagement.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @JsonProperty("Name")
    private String Name;

    @Column(name = "Email", unique = true)
    @JsonProperty("Email")
    private String Email;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("DateOfBirth")
    private LocalDate DateOfBirth;


}
