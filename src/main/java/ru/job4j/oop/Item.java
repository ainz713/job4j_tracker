package ru.job4j.oop;

import java.time.LocalDateTime;

public class Item {
    private String name;
    private int id;
    private LocalDateTime created = LocalDateTime.now();;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static void main(String[] args) {
        Item item = new Item();
    }
}
