package com.example.StudentManagement.Controllers;

import com.example.StudentManagement.Services.CourseService;
import com.example.StudentManagement.models.Course;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;
    @GetMapping("/Courses")
    @Operation(summary = "This endpoint is used to get all courses from the DB")
    public ResponseEntity<List<Course>>GetAllCourses(){
        return new ResponseEntity<>(courseService.GetAllCourses(), HttpStatus.OK);
    }
    @Operation(summary = "This endpoint is used to add course to the db")
    @PostMapping("/Courses")
    public ResponseEntity<Course> AddCourse( @RequestBody Course course){

        return new ResponseEntity<>(courseService.AddCourse(course),HttpStatus.CREATED);

    }
    @Operation(summary = "This endpoint is used to get details for a specific course")
    @GetMapping("/Courses/{id}")
    public  ResponseEntity<Course>GetCourseById(@PathVariable  int id){
        Course course = courseService.FindById(id);
                if(course!=null)
                    return new ResponseEntity<>(course,HttpStatus.OK);
                else
                    return ResponseEntity.notFound().build();
    }





}
