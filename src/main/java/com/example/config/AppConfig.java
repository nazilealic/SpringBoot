package com.example.config;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.model.Employee;

@Configuration
public class AppConfig {

	@Bean
	public List<Employee> employeeList(){
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("1","Enes", "Bayram"));
		employeeList.add(new Employee("2","Yakup", "Reçber"));
		employeeList.add(new Employee("3","Bilal", "Çamur"));
		employeeList.add(new Employee("4","Harun", "Kaymazalp"));
		employeeList.add(new Employee("5","Yasin", "Yazıcı"));
		employeeList.add(new Employee("6","Enes", "Yalçın"));
		
		return employeeList;
		
	}
}
