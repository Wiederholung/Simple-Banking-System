package com.metattri.se;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {
    @Test
    public void testCreate() {
        Student s = new Student("Yitong Hu");
        assertEquals("Yitong Hu", s.getName());
    }

    @Test
    public void testSetName() {
        Student s = new Student("Yitong");
        s.setName("Yitong Hu");
        assertEquals("Yitong Hu", s.getName());
    }

}