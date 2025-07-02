package com.example.rest_service.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/web-greeting")
    public String greetingPage(Model model) {
        model.addAttribute("message", "Hello from Thymeleaf!");
        return "greeting"; // corresponds to greeting.html
    }
}
