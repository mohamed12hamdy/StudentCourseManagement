package com.example.StudentManagement.Controller;

import com.example.StudentManagement.Dao.CourseRepository;
import com.example.StudentManagement.Dao.StudentRepository;
import com.example.StudentManagement.Services.CourseService;
import com.example.StudentManagement.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;
    @GetMapping("/Courses")
    public ResponseEntity<List<Course>>GetAllCourses(){
        return new ResponseEntity<>(courseService.GetAllCourses(), HttpStatus.OK);
    }

    @PostMapping("/Courses")
    public ResponseEntity<Course> AddCourse( @RequestBody Course course){

        return new ResponseEntity<>(courseService.AddCourse(course),HttpStatus.CREATED);

    }
    @GetMapping("/Courses/{id}")
    public  ResponseEntity<Course>GetCourseById(@PathVariable  int id){
        Course course = courseService.FindById(id);
                if(course!=null)
                    return new ResponseEntity<>(course,HttpStatus.OK);
                else
                    return ResponseEntity.notFound().build();
    }



}
