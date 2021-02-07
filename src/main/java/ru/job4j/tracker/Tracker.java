package ru.job4j.tracker;

import java.util.Arrays;

public final class Tracker {
    private static Tracker instance = null;
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private Tracker(){
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
            if (items[index].getId() == id) {
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
            System.arraycopy(items, rsl + 1, items, rsl, size - rsl);
            items[size - 1] = null;
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
            items[rsl] = item;
        }
        return result;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        int razmer = 0;
        Item[] rsl = new Item[size];
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getName().equals(key)) {
                rsl[razmer++] = item;
            }
        }
        return Arrays.copyOf(rsl, razmer);
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}