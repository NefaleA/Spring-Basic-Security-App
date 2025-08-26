package com.security_app.security_app.controller;

import com.security_app.security_app.entity.User;
import com.security_app.security_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("errorMessage", "Invalid username or password");
        }
        model.addAttribute("title", "Login");
        return "auth/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("title", "Register");
        return "auth/register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam Long id, @RequestParam String firstname, @RequestParam String middlename, @RequestParam String lastname, @RequestParam String email, @RequestParam String password, @RequestParam String phoneNumber, Model model) {

        if (userRepository.existsByEmail(email)) {
            model.addAttribute("errorMessage", "Email already exists.");
            model.addAttribute("title", "Register");
            return "auth/register";
        }

        if (userRepository.existsByUserPhoneNumber(phoneNumber)) {
            model.addAttribute("errorMessage", "Phone number already exists.");
            model.addAttribute("title", "Register");
            return "auth/register";
        }

        User user = new User();
        user.setFirstname(firstname);
        user.setMiddlename(middlename);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setPhoneNumber(phoneNumber);

        userRepository.save(user);

        model.addAttribute("successMessage", "Registration successful! Please login.");
        model.addAttribute("title", "Login");
        return "auth/login";
    }
}
