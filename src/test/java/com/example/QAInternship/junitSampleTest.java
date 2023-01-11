package com.example.QAInternship;

import com.example.QAInternship.service.junitSample;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class junitSampleTest {
    private junitSample x,y;
    @Test
    public void  testadd()
    {

        assertEquals(30, junitSample.add(10,20));
        assertEquals(30,junitSample.add(20,10));
        assertEquals(10,junitSample.add(-10,20));
        assertEquals(-30,junitSample.add(-10,-20));
        assertEquals(-10,junitSample.add(10,-20));
        assertEquals(20,junitSample.add(0,20));
        assertEquals(10,junitSample.add(10,0));
        assertEquals(-10,junitSample.add(-10,0));
       // assertEquals(30,junitSample.add(506.12,675.56));
        assertEquals(10,junitSample.add(-10,20));
        assertEquals(10,junitSample.add(-10,20));
    }

}
