package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Potok {
    public static void main(String[] args) {
        ArrayList<Integer> tasks = new ArrayList(Arrays.asList(100, -1, 300));
        List<Integer> bugs = tasks.stream().filter(
                task -> tasks.get(tasks.indexOf(task)) > 0
        ).collect(Collectors.toList());
        bugs.forEach(System.out::println);
    }
}
