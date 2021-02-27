package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {
    public List<Integer> mapflatmap(Integer[][] matrix) {
        return Stream.of(matrix).flatMap(e -> Stream.of(e)).collect(Collectors.toList()
        );
    }
}
