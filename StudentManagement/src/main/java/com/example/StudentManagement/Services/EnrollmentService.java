package com.example.StudentManagement.Services;

import com.example.StudentManagement.Dao.EnrollmentRepository;
import com.example.StudentManagement.Exception.EnrollmentNotFoundException;
import com.example.StudentManagement.models.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<String>GetAllcoursesForstud(int StudentId){
        List<String>CoursesNames = enrollmentRepository.findCourseNamesByStudentId(StudentId);
         return CoursesNames;
    }
    public List<String>GetAllStudentNamesForCourse(int courseId){
        List<String>StudentsNames = enrollmentRepository.findStudentNamesByCourseId(courseId);
        return StudentsNames;
    }
    public void DeleteStudentFromCourse(int studentId, int courseId){
        boolean exists = enrollmentRepository.existsByStudentIdAndCourseId(studentId, courseId);
        if (!exists) {
            throw new EnrollmentNotFoundException("Enrollment not found");
        }
        enrollmentRepository.deleteByStudentIdAndCourseId(studentId, courseId);

    }
}
