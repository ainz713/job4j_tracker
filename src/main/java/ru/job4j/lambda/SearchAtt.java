package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        return SearchAtt.filter(list, x -> x.getSize() > 100);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
       return SearchAtt.filter(list, x -> x.getName().contains("bug"));
    }

    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> predicate) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
          if (predicate.test(att)) {
              rsl.add(att);
          }
        }
        return rsl;
    }
}
