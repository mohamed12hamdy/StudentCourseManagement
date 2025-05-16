package com.example.StudentManagement.Exception;

public class StudentAlreadyExistsException extends RuntimeException {
    public StudentAlreadyExistsException(String s) {
        super(s);
    }

}
