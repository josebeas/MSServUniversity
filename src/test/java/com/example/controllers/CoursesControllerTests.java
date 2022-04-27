package com.example.controllers;

import com.example.dto.Course;
import com.example.repositories.CoursesRepository;
import com.example.services.CoursesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
public class CoursesControllerTests {

    @Mock
    private CoursesService coursesService;

    @Mock
    private CoursesRepository coursesRepository;

    @InjectMocks // auto inject CoursesService coursesService
    private CoursesController classUnderTest = new CoursesController();

    @BeforeEach
    void setup() {
        Course mockCourse = getMockCourse();
        when(coursesService.getCourse(any())).thenReturn(mockCourse);
        when(coursesService.addCourse(any())).thenReturn(mockCourse);
    }

    @Test
    void testGetCourse(){
        Course actualCourse = classUnderTest.getCourse("name");
        Course expectedCourse = getMockCourse();
        assertEquals(expectedCourse.getName(), actualCourse.getName(), "Course returned from service does not match");
    }

    @Test
    void testAddCourse(){
        Course actualCourse = classUnderTest.addCourse(new Course.Builder()
                .withName("name")
                .build());
        Course expectedCourse = getMockCourse();
        assertEquals(expectedCourse.getName(), actualCourse.getName(), "Course returned from service does not match");
    }

    @Test
    void testGetStatus(){
        String actualStatus = classUnderTest.getStatus();
        assertEquals("RUNNING!", actualStatus, "Course controller should be running");
    }

    private Course getMockCourse(){
        String name = "name";
        return new Course.Builder()
                .withName(name)
                .build();
    }

}
