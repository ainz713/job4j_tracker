package ru.job4j.collection;

import java.util.*;

public class FreezeStr {

    public static boolean eq(String left, String right) {
        HashMap<Character, Integer> map = new HashMap<>();
        var l = left.toCharArray();
        var r = right.toCharArray();
        for (var s
                : l) {
            int key = 0;
            for (char c : l) {
                if (c == s) {
                    key++;
                }
            }
            map.put(s, key);
        }
        for (var s
                : r) {
            if (!map.containsKey(s)) {
                return false;
            } else if (map.containsKey(s) && map.get(s) == 1) {
                    map.remove(s);
            } else if (map.containsKey(s) && map.get(s) > 1) {
                map.put(s, map.get(s) - 1);
            }
        }
      return map.isEmpty();
    }
}
