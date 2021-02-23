package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        List<Address> bugs = profiles.stream().map(
                task -> task.getAddress()
        ).collect(Collectors.toList());
        return bugs;
    }
}
