package com.example.StudentManagement.Services;

import com.example.StudentManagement.Dao.CourseRepository;
import com.example.StudentManagement.Exception.CourseAlreadyExistsException;
import com.example.StudentManagement.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
   private CourseRepository courseRepository;

    public List<Course>GetAllCourses(){
        return courseRepository.findAll();
    }
    public Course AddCourse(Course course){
        Optional<Course> existingcourse  = courseRepository.findByName(course.getName());
        if(existingcourse.isPresent()){
            throw new CourseAlreadyExistsException("Sorry,this course already exists");
        }
        return courseRepository.save(course);
    }
    public Course FindById(int id){
        return courseRepository.findById(id).orElse(null);

    }



}
