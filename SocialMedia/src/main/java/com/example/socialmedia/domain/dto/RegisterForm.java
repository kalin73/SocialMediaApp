package com.example.socialmedia.domain.dto;

public class RegisterForm {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String password;

    public String getUsername() {
        return username;
    }

    public RegisterForm setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterForm setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public RegisterForm setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public RegisterForm setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterForm setPassword(String password) {
        this.password = password;
        return this;
    }
}
