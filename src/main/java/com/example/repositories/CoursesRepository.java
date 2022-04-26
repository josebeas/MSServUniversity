package com.example.repositories;

import com.example.dto.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CoursesRepository extends MongoRepository<Course, String> {
    public Course findByName(String name);
}
