package com.example.StudentManagement.Services;

import com.example.StudentManagement.Dao.CourseRepository;
import com.example.StudentManagement.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
   private CourseRepository courseRepository;

    public List<Course>GetAllCourses(){
        return courseRepository.findAll();
    }


}
