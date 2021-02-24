package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SpisokstTest {
    private List<Student> students = new ArrayList<>();

    @Before
    public void setUp() {
        students.add(new Student(10, "Surname1"));
        students.add(new Student(20, "Surname2"));
    }

    @Test
    public void whenCollectClassA() {
        Spisokst sc = new Spisokst();
        Map<String, Object> m = sc.listvmap(students);
        Map<String, Object> expected = new HashMap<>();
        expected.put("Surname1", Student.class);
        expected.put("Surname2", Student.class);
        assertThat(m, is(expected));
    }
}