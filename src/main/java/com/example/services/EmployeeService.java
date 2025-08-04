package com.example.services;

import java.util.List;
import com.example.starter.SpringRestApiApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployeeList(){
		
		return employeeRepository.getAllEmployeeList();
	}
	
}
