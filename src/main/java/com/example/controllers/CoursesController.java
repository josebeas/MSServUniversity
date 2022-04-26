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
    public Course getCourse(String name){
        logger.info(String.format("Handling request for course with name", name));
        return coursesService.getCourse(
                new Course.Builder()
                        .withName(name)
                        .build());
    }

    @PostMapping(value = "/save", produces = "application/json")
    public Course addCourse(Course course){
        logger.info(String.format("Handling request for saving course with name", course.getName()));
        return coursesService.addCourse(course);
    }
}
