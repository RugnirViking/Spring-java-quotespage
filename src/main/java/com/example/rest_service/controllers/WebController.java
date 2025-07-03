package com.example.rest_service.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/web-greeting")
    public String greetingPage(Model model) {
        model.addAttribute("gradientStart", "#4e54c8");
        model.addAttribute("gradientEnd", "#8f94fb");
        model.addAttribute("quote", "The only limit to our realization of tomorrow is our doubts of today.");
        model.addAttribute("author", "Franklin D. Roosevelt");
        model.addAttribute("greeting", "GOOD MORNING");
        model.addAttribute("symbol", "sun"); // or "moon"
        model.addAttribute("bobaRecommendation", "Classic Milk Tea"); // optional
        return "greeting"; // corresponds to greeting.html
    }
}
