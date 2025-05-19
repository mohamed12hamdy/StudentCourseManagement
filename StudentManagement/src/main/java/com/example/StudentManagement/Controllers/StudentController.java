package com.example.StudentManagement.Controllers;

import com.example.StudentManagement.Services.StudentService;
import com.example.StudentManagement.models.Course;
import com.example.StudentManagement.models.Student;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Operation(summary = "This endpoint is used  to Retrieve all students")
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents()  {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }
    @Operation(summary = "This endpoint is used to insert student to the DB")
    @PostMapping("/students")
    public ResponseEntity <Student> AddStudent(@RequestBody Student student)  {
        Student savedStudent = studentService.AddStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }
    @Operation(summary = "This endpoint is used to get specific student by his-her id")
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
