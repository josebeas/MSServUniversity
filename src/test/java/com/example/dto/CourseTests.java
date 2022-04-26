package com.example.dto;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseTests {

    @Test
    public void testGetName(){
        Course classUnderTest = new Course.Builder().build();
        String expectedName = "name";
        classUnderTest.setName(expectedName);
        String actualName = classUnderTest.getName();
        assertEquals(actualName, expectedName, "property Name is not being updated on Course Dto");

    }

}
