package com.example.StudentManagement.Services;

import com.example.StudentManagement.Dao.StudentRepository;
import com.example.StudentManagement.Exception.CourseAlreadyExistsException;
import com.example.StudentManagement.Exception.StudentAlreadyExistsException;
import com.example.StudentManagement.models.Course;
import com.example.StudentManagement.models.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentrepository;



    public Student AddStudent(@RequestBody Student student) {
        Optional<Student> ExistingStudent  = studentrepository.findByEmail(student.getEmail());
        if(ExistingStudent.isPresent()){
            throw new StudentAlreadyExistsException("Sorry,this Student already exists");
        }
        return studentrepository.save(student);
    }


    public List<Student> getAllStudents() {
       return studentrepository.findAll();

    }
    public Student FindStudentById( int id){
        return studentrepository.findById(id).orElse(null);
    }

    public Student UpdateStudent(int id, Student UpdatedStudent){
        Student student = studentrepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setName(UpdatedStudent.getName());
        student.setEmail(UpdatedStudent.getEmail());
        student.setDateOfBirth(UpdatedStudent.getDateOfBirth());
        return studentrepository.save(student);
    }

}
