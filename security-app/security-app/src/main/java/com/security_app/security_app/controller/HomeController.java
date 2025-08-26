package com.security_app.security_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Security App");
        model.addAttribute("message", "Welcome to your Spring Boot Security Application!");
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About");
        model.addAttribute("message", "This is a Spring Boot application with Thymeleaf and Spring Security.");
        return "about";
    }
}
