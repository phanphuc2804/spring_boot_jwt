package com.example.spring_boot_jwt_phanhoangphuc.controller;

import com.example.spring_boot_jwt_phanhoangphuc.service.TokenService;
import com.example.spring_boot_jwt_phanhoangphuc.service.UserService;
import com.example.spring_boot_jwt_phanhoangphuc.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private TokenService tokenService;
}
