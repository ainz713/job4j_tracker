package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        item1.setId(1);
        item1.setName("Имя 1");
        tracker.add(item1);
        System.out.println((tracker.findById(1)).getName());
        Item item2 = new Item();
        item2.setId(2);
        item2.setName("Имя 2");
        System.out.println(item2.toString());
    }
}
