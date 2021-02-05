package ru.job4j.tracker;

public class FindAllItemsAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all Items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] massiv = tracker.findAll();
        for (int i = 0; i < massiv.length; i++) {
            System.out.println(massiv[i]);
        }
        return true;
    }
}
