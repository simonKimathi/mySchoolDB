package dev.symoh;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class TeachersTest {
    Teachers teachers=new Teachers();

    @Test
    void gettId() {
        teachers.settId("kim");
        assertEquals("kim",teachers.gettId());
    }

    @Test
    void settId() {
        teachers.settId("ken");
        assertEquals(teachers.gettId(),"ken");
    }

    @Test
    void gettName() {
        teachers.settName("simon");
        assertEquals("simon",teachers.gettName());
    }

    @Test
    void settName() {
        teachers.settName("symoh");
        assertEquals(teachers.gettName(),"symoh");
    }

    @Test
    void add() {
        teachers.settId("com");
        teachers.settName("simon");
       teachers.teacher.add(teachers);
        assertEquals(false,teachers.teacher.isEmpty());
    }

    @Test
    void delete() {
        teachers.settId("com");
        teachers.settName("simon");
        teachers.teacher.add(teachers);
        teachers.teacher.remove(0);
        assertEquals(true,teachers.teacher.isEmpty());
    }

    @Test
    void view() {
        teachers.settId("com");
        teachers.settName("simon");
        teachers.teacher.add(teachers);
        Iterator iterator=teachers.teacher.iterator();
        assertEquals(true,iterator.hasNext());
    }
}