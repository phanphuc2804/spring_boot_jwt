package com.example.spring_boot_jwt_phanhoangphuc.service;

import com.example.spring_boot_jwt_phanhoangphuc.entity.Token;

public interface TokenService {
    Token createToken(Token token);
}
