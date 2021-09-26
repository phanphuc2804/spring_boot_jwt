package com.example.spring_boot_jwt_phanhoangphuc.repository;

import com.example.spring_boot_jwt_phanhoangphuc.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
}
