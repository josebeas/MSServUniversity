package com.example.services.impl;

import com.example.controllers.CoursesController;
import com.example.dto.Course;
import com.example.repositories.CoursesRepository;
import com.example.services.CoursesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
public class CoursesServicesImplTests {

    private final String defaultCourseName = "courseName";
    @Mock
    private CoursesRepository coursesRepository;

    @InjectMocks // auto inject coursesRepository
    private CoursesService classUnderTest = new CoursesServiceImpl();

    @BeforeEach
    void setup() {
        Course mockCourse = getMockCourse();
        when(coursesRepository.findByName(null)).thenReturn(null);
        when(coursesRepository.findByName(defaultCourseName)).thenReturn(mockCourse);
        when(coursesRepository.save(any())).thenReturn(mockCourse);
    }

    @Test
    void testGetCourse(){
        Course actualCourse = classUnderTest.getCourse(defaultCourseName);
        Course expectedCourse = getMockCourse();
        assertEquals(expectedCourse.getName(), actualCourse.getName(), "Course returned from service does not match");
    }

    @Test
    void testGetCourse_null_course(){
        Course actualCourse = classUnderTest.getCourse(null);
        assertNull(actualCourse, "Course returned from service does not match");
    }

    @Test
    void testAddCourse(){
        Course actualCourse = classUnderTest.addCourse(new Course.Builder()
                .withName("name")
                .build());
        Course expectedCourse = getMockCourse();
        assertEquals(expectedCourse.getName(), actualCourse.getName(), "Course returned from service does not match");
    }

    private Course getMockCourse(){
        String name = "name";
        return new Course.Builder()
                .withName(name)
                .build();
    }

}
