package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/courses")
public class CoursesController {

    @GetMapping(value = "/status")
    public String getStatus() {
        return "RUNNING!";
    }
}
