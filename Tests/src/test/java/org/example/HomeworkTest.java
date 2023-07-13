package org.example;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class HomeworkTest {

    private Homework homework;

    @Before
    public void setUp() {
        homework = new Homework();
    }

    @Test
    public void printStringLambda() {
        String s = "Hello, World!";
        ByteArrayOutputStream outputBytes = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputBytes));
        homework.printStringLambda().accept(s);
        assertEquals(s + System.lineSeparator(), outputBytes.toString());
    }

    @Test
    public void upperCaseLambda() {
        String result = homework.upperCaseLambda().apply("hello world!");
        assertEquals("HELLO WORLD!", result);
    }

    @Test
    public void isGreaterThan10Lambda() {
        Predicate<Integer> isGreaterThan10 = homework.isGreaterThan10Lambda();
        assertTrue(isGreaterThan10.test(15));
        assertFalse(isGreaterThan10.test(10));
        assertFalse(isGreaterThan10.test(5));
    }
}