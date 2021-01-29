package ru.job4j.oop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void testMax() {
        int result = Max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void testTestMax() {
        int result = Max.max(1, 2, 3);
        assertThat(result, is(3));
    }

    @Test
    public void testTestMax1() {
        int result = Max.max(5, 2, 3, 9);
        assertThat(result, is(9));
    }
}