package com.example.demo3.service;

import com.example.demo3.entity.Course;
import com.example.demo3.entity.Student;
import com.example.demo3.repository.ICourseRepository;
import com.example.demo3.repository.IStudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentCourseService {

    private final IStudentRepository studentRepository;
    private final ICourseRepository courseRepository;

    public StudentCourseService(IStudentRepository studentRepository, ICourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    // Student CRUD
    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public Optional<Student> getStudentById(Long id){
        return studentRepository.findById(id);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student updateStudent(Long id, Student student){
        student.setId(id);
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    // Course CRUD
    public Course createCourse(Course course){
        return courseRepository.save(course);
    }

    public Optional<Course> getCourseById(Long id){
        return courseRepository.findById(id);
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Course updateCourse(Long id, Course course){
        course.setId(id);
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }

    // Assign course to student
    public Student assignCourseToStudent(Long studentId, Long courseId){
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        Optional<Course> courseOpt = courseRepository.findById(courseId);

        if(studentOpt.isPresent() && courseOpt.isPresent()){
            Student student = studentOpt.get();
            Course course = courseOpt.get();
            student.addCourse(course);
            return studentRepository.save(student);
        }
        return null;
    }
}
