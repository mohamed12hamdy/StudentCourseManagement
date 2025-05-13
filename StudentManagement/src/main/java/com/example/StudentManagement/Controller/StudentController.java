package com.example.StudentManagement.Controller;

import com.example.StudentManagement.Services.StudentService;
import com.example.StudentManagement.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents() throws Exception {
        return studentService.getAllStudents().getBody();
    }
    @PostMapping("/students")
    public Student AddStudent(@RequestBody Student student) throws Exception {
        return studentService.Add(student).getBody();
    }


}
