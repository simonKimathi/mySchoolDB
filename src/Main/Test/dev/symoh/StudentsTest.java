package dev.symoh;

import dev.symoh.students.Students;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class StudentsTest {
    Students students=new Students();
    //ovveride methods for test

    @Test
    void getsId() {
        students.setsId("kim");
        String n=students.getsId();
        assertEquals(n,"[kim]");
    }

    @Test
    void setsId() {
        students.setsId("jim");
        String n=students.getsId();
        assertEquals("[jim]",n);
    }

    @Test
    void getsName() {
        students.setsName("kim");
        String n=students.getsName();
        assertEquals(n,"[kim]");
    }

    @Test
    void setsName() {
        students.setsName("symoh");
        String n=students.getsName();
        assertEquals("[symoh]",n);
    }

    @Test
    void add() {
        students.setsId("com/0011/2015");
        students.setsName("simon kimathi");
        assertEquals(false,students.stuId.isEmpty());
    }

    @Test
    void delete() {
        students.setsId("com/0011/2015");
        students.stuId.remove(0);
        assertEquals(true,students.stuId.isEmpty());
    }

    @Test
    void view() {
        students.setsId("com/0011/2015");
        students.setsName("simon kimathi");
        Iterator iterator=students.stuId.iterator();
        assertEquals(true,iterator.hasNext());

    }
}