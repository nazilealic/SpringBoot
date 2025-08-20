package com.example.demo3.controller;

import com.example.demo3.entity.Course;
import com.example.demo3.service.StudentCourseService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@RequestMapping("/courses")
public class CourseController {

    private final StudentCourseService service;

    public CourseController(StudentCourseService service) {
        this.service = service;
    }

    @PostMapping
    public Course create(@RequestBody Course course){
        return service.createCourse(course);
    }

    @GetMapping("/{id}")
    public Optional<Course> getById(@PathVariable Long id){
        return service.getCourseById(id);
    }

    @GetMapping
    public List<Course> getAll(){
        return service.getAllCourses();
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable Long id, @RequestBody Course course){
        return service.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deleteCourse(id);
    }
}
