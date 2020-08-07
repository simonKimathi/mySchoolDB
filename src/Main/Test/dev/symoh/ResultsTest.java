package dev.symoh;

import dev.symoh.Results.Results;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ResultsTest {
    Results results=new Results();

    //ovveride methods for test

    @Test
    void getSid() {
        results.setSid("com");
        assertEquals("com",results.getSid());
    }

    @Test
    void setSid() {
        results.setSid("ken");
        assertEquals("ken",results.getSid());
    }

    @Test
    void getName() {
        results.setName("simon");
        assertEquals("simon",results.getName());
    }

    @Test
    void setName() {
        results.setName("ken");
        assertEquals(results.getName(),"ken");
    }

    @Test
    void getSubject() {
        results.setSubject("com112");
        assertEquals("com112",results.getSubject());
    }

    @Test
    void setSubject() {
        results.setSubject("com112");
        assertEquals(results.getSubject(),"com112");
    }

    @Test
    void getTeacherName() {
        results.setTeacherName("samwel");
        assertEquals("samwel",results.getTeacherName());
    }

    @Test
    void setTeacherName() {
        results.setTeacherName("samwel");
        assertEquals(results.getTeacherName(),"samwel");
    }

    @Test
    void getScore() {
        results.setScore(45);
        assertEquals(45,results.getScore());
    }

    @Test
    void setScore() {
        results.setScore(60);
        assertEquals(results.getScore(),60);
    }

    @Test
    void add() {
        results.setSid("com");
        results.setName("simon");
        results.setSubject("com101");
        results.setTeacherName("george");
        results.setScore(78);
        results.results.add(results);

        assertEquals(false,results.results.isEmpty());
    }

    @Test
    void delete() {
        results.setSid("com");
        results.setName("simon");
        results.setSubject("com101");
        results.setTeacherName("george");
        results.setScore(78);
        results.results.add(results);
        results.results.remove(0);

        assertEquals(true,results.results.isEmpty());
    }

    @Test
    void view() {
        results.setSid("com");
        results.setName("simon");
        results.setSubject("com101");
        results.setTeacherName("george");
        results.setScore(78);
        results.results.add(results);
        Iterator iterator=results.results.iterator();

        assertEquals(true,iterator.hasNext());
    }
}