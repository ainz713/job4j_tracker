package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.collection.ConvertList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortItembyVTest {

    @Test
    public void testV() {
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        item1.setId(4);
        item2.setId(1);
        item3.setId(2);
        List<Item> items = Arrays.asList(
                item1,
                item2,
                item3
        );
        Collections.sort(items, new SortItembyV());
        assertThat(new int[]{items.get(0).getId(), items.get(1).getId(),
                items.get(2).getId()}, is(new int[]{1, 2, 4}));
    }

    @Test
    public void testY() {
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        item1.setId(4);
        item2.setId(1);
        item3.setId(2);
        List<Item> items = Arrays.asList(
                item1,
                item2,
                item3
        );
        Collections.sort(items, new SortItembyY());
        assertThat(new int[]{items.get(0).getId(), items.get(1).getId(),
                items.get(2).getId()}, is(new int[]{4, 2, 1}));
    }
}