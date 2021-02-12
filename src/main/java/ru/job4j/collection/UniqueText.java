package ru.job4j.collection;

import java.util.HashSet;
import java.util.Set;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        /* for-each origin -> new HashSet. */
        for (String e:
             origin) {
           check.add(e);
        }
        for (String e:
             text) {
            if (!check.contains(e)) {
                rsl = false;
                break;
            }
        }
        /* for-each text -> hashSet.contains */
        return rsl;
    }
}
