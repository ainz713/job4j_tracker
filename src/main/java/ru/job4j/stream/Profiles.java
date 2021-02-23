package ru.job4j.stream;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        Comparator<Address> comparator = new Comparator<Address>() {
            @Override
            public int compare(Address left, Address right) {
                return left.getCity().compareTo(right.getCity());
            }
        };
        List<Address> bugs = profiles.stream().map(
                task -> task.getAddress()
        )
                .sorted(comparator)
                .distinct()
                .collect(Collectors.toList());
        return bugs;
    }
}
