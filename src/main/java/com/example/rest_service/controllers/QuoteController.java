package com.example.rest_service.controllers;

import java.util.concurrent.atomic.AtomicLong;

// Our stuff


import com.example.rest_service.models.Author;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Author greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Author(counter.incrementAndGet(), String.format(template, name));
    }
}