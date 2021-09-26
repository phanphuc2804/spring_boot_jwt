package com.example.spring_boot_jwt_phanhoangphuc.controller;

import com.example.spring_boot_jwt_phanhoangphuc.entity.User;
import com.example.spring_boot_jwt_phanhoangphuc.service.TokenService;
import com.example.spring_boot_jwt_phanhoangphuc.service.UserService;
import com.example.spring_boot_jwt_phanhoangphuc.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/register")
    public User register(@RequestBody User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userService.createUser(user);
    }
}
