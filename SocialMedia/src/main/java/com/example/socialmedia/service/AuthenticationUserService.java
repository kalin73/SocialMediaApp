package com.example.socialmedia.service;

import com.example.socialmedia.domain.entity.UserEntity;
import com.example.socialmedia.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationUserService implements UserDetailsService {
    private final UserRepository userRepository;

    public AuthenticationUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = this.userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email: " + email + " does not exist!"));

        return new User(email, user.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_")));
    }
}
