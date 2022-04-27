package com.example.services;

import com.example.dto.Course;
import org.springframework.stereotype.Service;

@Service
public interface CoursesService {

    public Course getCourse(String courseName);

    public Course addCourse(Course course);
}
