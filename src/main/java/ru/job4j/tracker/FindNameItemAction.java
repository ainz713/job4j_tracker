package ru.job4j.tracker;

import java.util.List;

public class FindNameItemAction implements UserAction {
    private final Output out;

    public FindNameItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by name";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        String imya = input.askStr("--> Enter item name: ");
        List<Item> massiv = memTracker.findByName(imya);
        if (massiv.size() != 0) {
            for (int i = 0; i < massiv.size(); i++) {
                out.println(massiv.get(i));
            }
        } else {
            out.println("No such item with name " + "\"" + imya + "\"");
        }
        return true;
    }
}
