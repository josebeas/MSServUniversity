package com.example.controllers;

import com.example.dto.Course;
import com.example.services.CoursesService;
import com.example.services.impl.CoursesServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_GATEWAY;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/v1/courses")
public class CoursesController {

    Logger logger = LoggerFactory.getLogger(CoursesController.class);

    @Autowired
    CoursesService coursesService;

    @GetMapping(value = "/status")
    public String getStatus() {
        return "RUNNING!";
    }

    @GetMapping(value = "/find", produces = "application/json")
    public Course getCourse(String courseName){
        logger.info(String.format("Handling request for course with name", courseName));
        Course result = null;
        try {
            result = coursesService.getCourse(courseName);
        } catch (Exception e) {
            throw new ResponseStatusException(BAD_GATEWAY, "Gateway time out");
        }
        if(result == null){
            throw new ResponseStatusException(NOT_FOUND, "No data found");
        }
        return result;
    }

    @PostMapping(value = "/save", produces = "application/json")
    public Course addCourse(Course course){
        logger.info(String.format("Handling request for saving course with name", course.getName()));
        return coursesService.addCourse(course);
    }
}
