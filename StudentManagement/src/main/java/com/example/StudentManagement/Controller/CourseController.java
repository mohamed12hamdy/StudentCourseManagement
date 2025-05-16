package com.example.StudentManagement.Controller;

import com.example.StudentManagement.Services.CourseService;
import com.example.StudentManagement.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;
    @GetMapping("/Courses")
    public ResponseEntity<List<Course>>GetAllCourses(){
        return new ResponseEntity<>(courseService.GetAllCourses(), HttpStatus.OK);
    }



}
