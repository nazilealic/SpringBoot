package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entites.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer > {//islem yapacağı sınıf , pk mız olan id değeri int old için int

	
}