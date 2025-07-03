package com.example.rest_service.controllers;

import com.example.rest_service.services.GreetingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Clock;
import java.time.ZoneId;

@Controller
public class WebController {

    private final GreetingService greetingService;
    private static final ZoneId CPH = ZoneId.of("Europe/Copenhagen");

    public WebController() {
        this.greetingService = new GreetingService(Clock.system(CPH),CPH);
    }

    @GetMapping("/web-greeting")
    public String greetingPage(Model model) {
        model.addAttribute("gradientStart", "#4e54c8");
        model.addAttribute("gradientEnd", "#8f94fb");
        model.addAttribute("quote", "The only limit to our realization of tomorrow is our doubts of today.");
        model.addAttribute("author", "Franklin D. Roosevelt");
        model.addAttribute("greeting", greetingService.getGreeting());
        model.addAttribute("symbol", greetingService.getSymbol()); // or "moon"
        model.addAttribute("bobaRecommendation", "Classic Milk Tea"); // optional
        return "greeting"; // corresponds to greeting.html
    }
}
