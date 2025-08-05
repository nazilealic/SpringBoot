package com.example.services;

import java.util.List;
import com.example.starter.SpringRestApiApplication;

import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployeeList(){
		
		return employeeRepository.getAllEmployeeList();
	}
	
	public Employee getEmployeeById(String id) {
		return employeeRepository.getEmployeeById(id);
	}
	public List<Employee> getEmployeeWithParams(String firstName,String lastName){
		return employeeRepository.getEmployeeWithParams(firstName, lastName);
		
	}
}
