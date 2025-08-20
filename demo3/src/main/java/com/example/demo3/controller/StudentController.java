package com.example.demo3.controller;

import com.example.demo3.entity.Student;
import com.example.demo3.service.StudentCourseService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@RequestMapping("/students")
public class StudentController {

    private final StudentCourseService service;

    public StudentController(StudentCourseService service) {
        this.service = service;
    }

    @PostMapping
    public Student create(@RequestBody Student student){
        return service.createStudent(student);
    }

    @GetMapping("/{id}")
    public Optional<Student> getById(@PathVariable Long id){
        return service.getStudentById(id);
    }

    @GetMapping
    public List<Student> getAll(){
        return service.getAllStudents();
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student){
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deleteStudent(id);
    }

    @PostMapping("/{studentId}/courses/{courseId}")
    public Student assignCourse(@PathVariable Long studentId, @PathVariable Long courseId){
        return service.assignCourseToStudent(studentId, courseId);
    }
}
