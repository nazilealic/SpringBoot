package com.example.Spring_Security_Example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Spring_Security_Example.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByName(String name);
    User findByName(String username);
}
