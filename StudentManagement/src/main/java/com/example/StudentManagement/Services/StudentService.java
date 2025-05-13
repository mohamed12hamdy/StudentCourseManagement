package com.example.StudentManagement.Services;

import com.example.StudentManagement.Dao.StudentRepository;
import com.example.StudentManagement.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.logging.Handler;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentrepository;

    public ResponseEntity<Student> Add(@RequestBody Student student) throws Exception {
        Student savedStudent = null;
        try {
            savedStudent =  studentrepository.save(student);
        }
        catch (Exception ex) {
            System.out.println("Entered Execption");
            throw new Exception("Failed to save student: " + ex.getMessage(), ex);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }


    public ResponseEntity<List<Student>> getAllStudents() throws Exception {
        List<Student> all;
        try {
            all = studentrepository.findAll();
        } catch (Exception ex) {
            throw new Exception("Failed to Get students data: " + ex.getMessage(), ex);
        }
        return ResponseEntity.status(HttpStatus.OK).body(all);
    }

}
