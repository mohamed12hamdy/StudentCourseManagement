package com.example.StudentManagement.Controller;

import com.example.StudentManagement.Services.StudentService;
import com.example.StudentManagement.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents()  {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }
    @PostMapping("/students")
    public ResponseEntity <Student> AddStudent(@RequestBody Student student)  {
        Student savedStudent = studentService.Add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<Student>GetStudentById(@PathVariable int id){
     Student student = studentService.FindStudentById(id);
      if(student != null) {
          return ResponseEntity.ok(student);

      }
      else{
              return ResponseEntity.notFound().build();
          }
    }



}
