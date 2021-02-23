package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    private List<Profile> spisok = new ArrayList<>();
    private Profile address1 = new Profile();
    private Profile address2 = new Profile();
    private Profile address3 = new Profile();
    private Profile address4 = new Profile();
    private Profile address5 = new Profile();

    @Before
    public void setUp() {
        spisok.add(address1);
        spisok.add(address2);
        spisok.add(address3);
        spisok.add(address4);
        spisok.add(address5);
        address1.setAddress(new Address("Moscow", "Ulica1", 10, 11));
        address2.setAddress(new Address("Moscow", "Ulica1", 10, 11));
        address3.setAddress(new Address("Moscow", "Ulica4", 10, 11));
        address4.setAddress(new Address("Chicago", "Ulica2", 11, 143));
        address5.setAddress(new Address("New York", "Ulica3", 1231, 145));
    }

    @Test
    public void whenCollect() {
        Profiles sc = new Profiles();
        List<Address> rsl = sc.collect(spisok);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Chicago", "Ulica2", 11, 143));
        expected.add(new Address("Moscow", "Ulica1", 10, 11));
        expected.add(new Address("Moscow", "Ulica4", 10, 11));
        expected.add(new Address("New York", "Ulica3", 1231, 145));
        assertThat(rsl, is(expected));
    }
}