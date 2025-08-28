package com.example.Spring_Security_Example.util;


import com.example.Spring_Security_Example.model.Role;
import com.example.Spring_Security_Example.repository.RoleRepository;
import com.example.Spring_Security_Example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import com.example.Spring_Security_Example.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoad implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Role roleAdmin = roleRepository.findByRoleName("ROLE_ADMIN")
                .orElseGet(() -> roleRepository.save(Role.builder().roleName("ROLE_ADMIN").build()));
        Role roleUser = roleRepository.findByRoleName("ROLE_USER")
                .orElseGet(() -> roleRepository.save(Role.builder().roleName("ROLE_USER").build()));

        if (!userRepository.existsByName("Burak")) {
            User admin = User.builder()
                    .name("Burak")
                    .password(passwordEncoder.encode("1234"))
                    .roles(List.of(roleAdmin))
                    .build();
            userRepository.save(admin);
        }

        if (!userRepository.existsByName("Ali")) {
            User user = User.builder()
                    .name("Ali")
                    .password(passwordEncoder.encode("1234"))
                    .roles(List.of(roleUser))
                    .build();
            userRepository.save(user);
        }

        System.out.println("-- Roles --");
        roleRepository.findAll().forEach(System.out::println);
        System.out.println("-- Users --");
        userRepository.findAll().forEach(System.out::println);
    }
}
