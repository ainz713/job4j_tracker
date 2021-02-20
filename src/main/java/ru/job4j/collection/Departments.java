package ru.job4j.collection;

import java.util.*;

public class Departments implements Comparator<String> {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if (start.equals("")) {
                    tmp.add(el);
                    start = el;
                    continue;
                }
                tmp.add(start + "/" + el);
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
