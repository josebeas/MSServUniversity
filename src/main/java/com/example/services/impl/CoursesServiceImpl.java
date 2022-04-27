package com.example.services.impl;

import com.example.dto.Course;
import com.example.repositories.CoursesRepository;
import com.example.services.CoursesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoursesServiceImpl implements CoursesService {

    Logger logger = LoggerFactory.getLogger(CoursesServiceImpl.class);

    @Autowired
    CoursesRepository coursesRepository;

    @Override
    public Course getCourse(String courseName) {
        logger.info(String.format("Searching for courses with name %s", courseName));
        Course results = coursesRepository.findByName(courseName);
        if (results == null){
            logger.info(String.format("No results found for course with name %s", courseName));
            return new Course.Builder()
                    .withName(courseName)
                    .build();
        }
        return results;
    }

    @Override
    public Course addCourse(Course course) {
        logger.info(String.format("Saving course with name %s", course.getName()));
        return  coursesRepository.save(course);
    }
}
