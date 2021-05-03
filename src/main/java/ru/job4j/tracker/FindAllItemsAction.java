package ru.job4j.tracker;

import java.util.List;

public class FindAllItemsAction implements UserAction {
    private final Output out;

    public FindAllItemsAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show all Items ====";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        List<Item> massiv = memTracker.findAll();
        for (int i = 0; i < massiv.size(); i++) {
            out.println(massiv.get(i));
        }
        return true;
    }
}
