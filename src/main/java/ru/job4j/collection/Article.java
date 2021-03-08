package ru.job4j.collection;

import java.util.Collections;
import java.util.HashSet;

public class Article {
    public static boolean generateBy(String origin, String line) {
        HashSet<String> sp1 = new HashSet<>();
        String[] sp2 = line.replaceAll("[,.!;:]", "").split(" ");
        Collections.addAll(sp1, sp2);
        for (String s
                : sp1) {
            if (!origin.contains(s)) {
                return false;
            }
        }
        return true;
    }
}

