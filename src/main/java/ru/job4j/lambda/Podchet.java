package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Podchet {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<>();
        for (double index = start; index < end; index++) {
            rsl.add(func.apply(index));
        }
        return rsl;
    }
}
