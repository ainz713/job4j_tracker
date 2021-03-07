package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private ArrayList<Integer> rsl;

    static class Builder {
        private ArrayList<Integer> rsl;

        public Builder rslList(List<Integer> source) {
           this.rsl = new ArrayList<>(source);
            return this;
        }

        EasyStream build() {
            EasyStream easyStream = new EasyStream();
            easyStream.rsl = rsl;
            return easyStream;
        }
    }

    public static EasyStream of(List<Integer> source) {
        return new Builder()
        .rslList(source)
        .build();
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        ArrayList<Integer> rsl1 = new ArrayList<>();
        for (Integer integer : rsl) {
            int a = fun.apply(integer);
            rsl1.add(a);
        }
        return EasyStream.of(rsl1);
    }

    public EasyStream filter(Predicate<Integer> fun1) {
        ArrayList<Integer> rsl1 = new ArrayList<>();
        for (Integer integer : rsl) {
            if (fun1.test(integer)) {
                rsl1.add(integer);
            }
        }
        return EasyStream.of(rsl1);
    }

    public List<Integer> collect() {
      return rsl;
    }
}
