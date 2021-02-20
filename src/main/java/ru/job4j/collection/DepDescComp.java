package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] array1 = o1.split("/");
        String[] array2 = o2.split("/");
        int rsl = array2[0].compareTo(array1[0]);
        if (rsl == 0) {
            return o1.compareTo(o2);
        }
        return rsl;
    }
}
