package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SpisokstTest {
    private List<Student> students = new ArrayList<>();
    private Student a = new Student(10, "Surname1");
    private Student b = new Student(20, "Surname2");
    private Student c = new Student(20, "Surname2");

    @Test
    public void whenCollectClassA() {
        Spisokst sc = new Spisokst();
        students.add(a);
        students.add(b);
        students.add(c);
        Map<String, Student> m = sc.listvmap(students);
        Map<String, Student> expected = new HashMap<>();
        List<Student> newList = List.of(a, b);
        expected.put("Surname1", a);
        expected.put("Surname2", b);
        assertThat(m, is(expected));
    }
}