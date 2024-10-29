package com.danielfreitassc.api_example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example-api")
public class ApiTestController {
    
    @GetMapping
    public String getHello(@RequestParam String message) {
        return  message;
    }
}
