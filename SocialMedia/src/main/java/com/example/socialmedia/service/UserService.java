package com.example.socialmedia.service;

import com.example.socialmedia.domain.dto.RegisterForm;
import com.example.socialmedia.domain.entity.UserEntity;
import com.example.socialmedia.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(RegisterForm registerForm) {
        UserEntity user = new UserEntity();
        user.setEmail(registerForm.getEmail())
                .setUsername(registerForm.getUsername())
                .setFirstName(registerForm.getFirstName())
                .setLastName(registerForm.getLastName())
                .setPassword(passwordEncoder.encode(registerForm.getPassword()));

        this.userRepository.save(user);
    }
}
