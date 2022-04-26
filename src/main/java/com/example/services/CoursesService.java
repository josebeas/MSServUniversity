package com.example.services;

import com.example.dto.Course;
import org.springframework.stereotype.Service;

@Service
public interface CoursesService {

    public Course getCourse(Course course);

    public Course addCourse(Course course);
}
