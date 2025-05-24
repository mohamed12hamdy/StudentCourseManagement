package com.example.StudentManagement.Exception;

public class EnrollmentNotFoundException extends RuntimeException{
    public EnrollmentNotFoundException(String message) {
        super(message);
    }
}
