package com.example.socialmedia.web;

import com.example.socialmedia.domain.dto.RegisterForm;
import com.example.socialmedia.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")
    public String getRegisterPage() {
        return "registerOrLogin";
    }

    @PostMapping("/register")
    public String registerUser(RegisterForm registerForm) {
        this.userService.registerUser(registerForm);

        return "registerOrLogin";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "registerOrLogin";
    }
}
