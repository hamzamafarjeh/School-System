package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
    @GetMapping("/public/hello")
    public String publicHello() {
        return "Hello World (Public)";
    }

    // API مع login
    @GetMapping("/private/hello")
    public String privateHello() {
        return "Hello World (Private)";
    }
}

