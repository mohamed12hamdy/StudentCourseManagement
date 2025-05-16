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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.logging.Handler;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentrepository;

    public Student Add(@RequestBody Student student) {

        return studentrepository.save(student);
    }


    public List<Student> getAllStudents() {
       return studentrepository.findAll();

    }
    public Student FindStudentById( int id){
        return studentrepository.findById(id).orElse(null);
    }

}
