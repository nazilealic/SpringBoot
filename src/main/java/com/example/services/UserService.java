package com.example.services;

import java.util.List;

import com.example.model.User; // doğru import

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserService {
    private List<User> userList;
}
