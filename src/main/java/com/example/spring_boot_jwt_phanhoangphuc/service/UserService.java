package com.example.spring_boot_jwt_phanhoangphuc.service;

import com.example.spring_boot_jwt_phanhoangphuc.authen.UserPrincipal;
import com.example.spring_boot_jwt_phanhoangphuc.entity.User;

public interface UserService {
    User createUser(User user);
    UserPrincipal findbyUsername(String username);
}
