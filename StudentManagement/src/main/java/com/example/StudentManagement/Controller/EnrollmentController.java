package com.example.StudentManagement.Controller;

import com.example.StudentManagement.Services.EnrollmentService;
import com.example.StudentManagement.models.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;
    @PostMapping("/Enroll")
    public ResponseEntity<?> EnrollStudent(@RequestBody Enrollment enrollment){
        if(enrollmentService.Register(enrollment))
        return new ResponseEntity<>("student registered successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Student is already enrolled in this course", HttpStatus.CONFLICT);

    }

}
