package com.example.StudentManagement.Controllers;

import com.example.StudentManagement.Services.EnrollmentService;
import com.example.StudentManagement.models.Enrollment;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;
    @PostMapping("/Enroll")
    @Operation(summary = "This endpoint is used to enroll a student for a specific course")
    public ResponseEntity<?> EnrollStudent(@RequestBody Enrollment enrollment){
        if(enrollmentService.Register(enrollment))
        return new ResponseEntity<>("student registered successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Student is already enrolled in this course", HttpStatus.CONFLICT);

    }

    @GetMapping("/Enroll/{StudentId}/courses")
    @Operation(summary = "This endpoint is used to get courses names that a student enrolled")
    public ResponseEntity <List<String>>GetAllCoursesForStudent(@PathVariable int StudentId){
       return new ResponseEntity<>(enrollmentService.GetAllcoursesForstud(StudentId),HttpStatus.OK);
    }

    @GetMapping("/Enrolledstudents/{courseId}/courses")
    @Operation(summary = "This endpoint is used to get student names that joined a specific course")
    public ResponseEntity<List<String>>GetAllStudentNamesForCourse(@PathVariable  int courseId){
        return new ResponseEntity<>(enrollmentService.GetAllStudentNamesForCourse(courseId),HttpStatus.OK);
    }



}
