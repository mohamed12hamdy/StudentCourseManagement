package com.example.StudentManagement.Exception;

public class CourseAlreadyExistsException extends RuntimeException{
    public CourseAlreadyExistsException(String message) {
        super(message);
    }

}
