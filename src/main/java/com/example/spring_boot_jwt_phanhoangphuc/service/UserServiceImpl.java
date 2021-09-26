package com.example.spring_boot_jwt_phanhoangphuc.service;

import com.example.spring_boot_jwt_phanhoangphuc.authen.UserPrincipal;
import com.example.spring_boot_jwt_phanhoangphuc.entity.User;
import com.example.spring_boot_jwt_phanhoangphuc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public UserPrincipal findbyUsername(String username) {
        User user= userRepository.findByUsername(username);
        UserPrincipal userPrincipal= new UserPrincipal();

        if (user != null) {
            Set<String> authorities= new HashSet<>();
            if (user.getRoles() != null) {
                user.getRoles().forEach(role -> {
                    authorities.add(role.getRoleKey());
                    role.getPermissions().forEach(permission -> authorities.add(permission.getPermissionKey()));
                });
            }
            userPrincipal.setUserId(user.getId());
            userPrincipal.setUsername(user.getUsername());
            userPrincipal.setPassword(user.getPassword());
            userPrincipal.setAuthorities(authorities);
        }
        return userPrincipal;
    }
}
