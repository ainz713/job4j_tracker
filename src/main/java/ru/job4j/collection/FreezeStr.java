package ru.job4j.collection;

import java.util.*;

public class FreezeStr {

    public static boolean eq(String left, String right) {
        HashMap<Integer, String> map = new HashMap<>();
        HashMap<Integer, String> map1 = new HashMap<>();
        var l = left.split("");
        var r = right.split("");
        int key = 0;
        for (var s
                : l) {
            map.put(key, s);
            key++;
        }
        key = 0;
        for (var s
                : r) {
            map1.put(key, s);
            key++;
        }

        List<String> listl = new ArrayList<>(map.values());

        List<String> listr = new ArrayList<>(map1.values());

        Collections.sort(listl);
        Collections.sort(listr);

      return listl.equals(listr);
    }
}
