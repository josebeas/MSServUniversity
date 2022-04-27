package com.example.dto;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseTests {

    @Test
    public void test_CourseName(){
        Course classUnderTest = new Course.Builder().build();
        String expectedName = "name";
        classUnderTest.setName(expectedName);
        String actualName = classUnderTest.getName();
        assertEquals(expectedName, actualName, "property Name is not being updated on Course Dto");

    }

    @Test
    public void test_CourseLastName(){
        Course classUnderTest = new Course.Builder().build();
        String expectedLastname = "lastname";
        classUnderTest.setLastname(expectedLastname);
        String actualLastname = classUnderTest.getLastname();
        assertEquals(expectedLastname, actualLastname,"property Lastname is not being updated on Course Dto");
    }

    @Test
    public void test_CourseScore(){
        Course classUnderTest = new Course.Builder().build();
        Double expectedScore = 4d;
        classUnderTest.setScore(expectedScore);
        Double actualScore = classUnderTest.getScore();
        assertEquals(expectedScore, actualScore,"property Lastname is not being updated on Course Dto");
    }

    @Test
    public void test_CourseBuilderName(){
        String expectedName = "name";
        Course classUnderTest = new Course.Builder()
                .withName(expectedName)
                .build();

        String actualName = classUnderTest.getName();
        assertEquals(expectedName, actualName, "property Name is not being added into Course Dto");

    }

    @Test
    public void test_CourseBuilderLastName(){
        String expectedLastname = "lastname";
        Course classUnderTest = new Course.Builder()
                .withLastname(expectedLastname)
                .build();

        String actualLastname = classUnderTest.getLastname();
        assertEquals(expectedLastname, actualLastname,"property Lastname is not being added into Course Dto");
    }

    @Test
    public void test_CourseBuilderScore(){
        Double expectedScore = 4d;
        Course classUnderTest = new Course.Builder()
                .withScore(expectedScore)
                .build();

        Double actualScore = classUnderTest.getScore();
        assertEquals(expectedScore, actualScore,"property Lastname is not being added into Course Dto");
    }


}
