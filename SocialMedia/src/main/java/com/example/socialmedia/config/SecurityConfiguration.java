package com.example.socialmedia.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(request -> request.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers("/", "/auth/login", "/auth/register").permitAll())
                .formLogin(login -> login.loginPage("/auth/login")
                        .defaultSuccessUrl("/", true)
                        .failureForwardUrl("/auth/login-error")
                        .usernameParameter("email"))
                .logout(logout -> logout.logoutUrl("/auth/logout").logoutSuccessUrl("/").invalidateHttpSession(true));

        return httpSecurity.build();
    }
}
