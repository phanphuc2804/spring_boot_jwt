package com.example.spring_boot_jwt_phanhoangphuc.service;

import com.example.spring_boot_jwt_phanhoangphuc.entity.Token;
import com.example.spring_boot_jwt_phanhoangphuc.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService{
    @Autowired
    private TokenRepository tokenRepository;

    public Token createToken(Token token) {
        return tokenRepository.saveAndFlush(token);
    }
}
