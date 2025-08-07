package com.example.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.IStudentController;
import com.example.entites.Student;
import com.example.repository.StudentRepository;
import com.example.services.IStudentService;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController {

    private final StudentRepository studentRepository;

	@Autowired
	private IStudentService studentService;

    StudentControllerImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
	
	@PostMapping(path = "/save")
	@Override
	public Student saveStudent(@RequestBody Student student) {
		
		return studentService.saveStudent(student);
	}
	
}
