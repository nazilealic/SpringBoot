package com.example.demo3.repository;

import com.example.demo3.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,Long> {
}
