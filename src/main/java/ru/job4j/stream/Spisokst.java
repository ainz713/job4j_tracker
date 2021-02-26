package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Spisokst {
    public Map<String, Student> listvmap(List<Student> students) {
        return students.stream().distinct().collect(
                Collectors.toMap(
                       Student::getSurname,
                        e -> e,
                        (f, s) -> f
                )
);
    }
}
