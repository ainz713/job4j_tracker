package ru.job4j.collection;

import java.util.Comparator;

    public class StringCompare implements Comparator<String> {
        @Override
        public int compare(String left, String right) {
            char[] array1 = left.toCharArray();
            char[] array2 = right.toCharArray();
            int rez = 0;
            if (array1.length == array2.length) {
                for (int i = 0; i < array1.length; i++) {
                    rez = Character.compare(array1[i], array2[i]);
                    if (rez != 0) {
                        break;
                    }
                }
            } else {
                return Integer.compare(array1.length, array2.length);
            }
            return rez;
        }
    }

