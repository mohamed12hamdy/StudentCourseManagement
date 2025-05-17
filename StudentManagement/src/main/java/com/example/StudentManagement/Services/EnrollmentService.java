package com.example.StudentManagement.Services;

import com.example.StudentManagement.Dao.EnrollmentRepository;
import com.example.StudentManagement.models.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    public boolean Register(Enrollment enrollment){
        if(enrollmentRepository.existsByStudentIdAndCourseId(enrollment.getStudent().getId(),enrollment.getCourse().getId()))
       return false;

        else {
            enrollmentRepository.save(enrollment);
            return true;

        }

    }
}
