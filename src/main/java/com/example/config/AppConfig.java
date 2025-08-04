package com.example.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.model.User;
import com.example.services.UserService;

@Configuration
public class AppConfig {

    @Bean
    public UserService userService() {
        UserService userService = new UserService();

        List<User> userList = new ArrayList<>();
        userList.add(new User(null));
        userList.add(new User("Nazile"));
        userList.add(new User("Gunes"));

        userService.setUserList(userList);

        return userService;
    }
}
