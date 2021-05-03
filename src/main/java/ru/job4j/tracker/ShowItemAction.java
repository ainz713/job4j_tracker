package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.List;

public class ShowItemAction implements UserAction {
    private final Output out;

    public ShowItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Store memTracker) throws SQLException {
        List<Item> items = memTracker.findAll();
        if (items.size() != 0) {
            for (Item i : items) {
                out.println(i);
            }
        } else {
            out.println("No items to show");
        }
        return true;
//        int nomer = input.askInt("--> Enter item id to replace: ");
//        String imya = input.askStr("--> Enter item name to replace from: ");
//        Item temp = new Item(nomer, imya);
//        if (memTracker.replace(nomer, temp)) {
//            out.println("Item with id " + nomer + " update");
//        } else {
//            out.println("No such id");
//        }
//        return true;
    }
}
