package ru.job4j.tracker;

import java.sql.SQLException;

public class FindIdItemAction implements UserAction {
    private final Output out;

    public FindIdItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Store memTracker) throws SQLException {
        int nomer = input.askInt("--> Enter item id: ");
        Item temp = memTracker.findById(nomer);
        if (temp != null) {
            out.println(temp);
        } else {
            out.println("No such item with id " + nomer);
        }
        return true;
    }
}
