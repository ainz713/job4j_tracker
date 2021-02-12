package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Tracker {
    private static Tracker instance = null;
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Tracker(){
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean delete(int id) {
       boolean result = false;
        int rsl = indexOf(id);
        if (rsl != -1) {
            result = true;
            items.remove(rsl);
            size--;
        }
        return result;
    }

    public boolean replace(int id, Item item) {
        boolean result = false;
       int rsl = indexOf(id);
       item.setId(id);
        if (rsl != -1) {
            result = true;
            items.add(rsl, item);
        }
        return result;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(size++, item);
        return item;
    }

    public List<Item> findAll() {
        //return List.copyOf(new ArrayList<Item>(size));
        return items;
    }

    public List<Item> findByName(String key) {
        int razmer = 0;
        List<Item> rsl = new ArrayList<>(size);
        for (int index = 0; index < size; index++) {
            Item item = items.get(index);
            if (item.getName().equals(key)) {
                rsl.add(razmer++, item);
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items.get(index);
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}