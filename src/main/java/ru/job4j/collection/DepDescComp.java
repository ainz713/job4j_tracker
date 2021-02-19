package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        char[] array1 = o1.toCharArray();
        char[] array2 = o2.toCharArray();
        int rez = Character.compare(array2[0], array1[0]);
        if (rez == 0) {
            return new Departments().compare(o1, o2);
        }
        return rez;
    }
}
