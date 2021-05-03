package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Replace item";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        int nomer = input.askInt("--> Enter item id to replace: ");
        String imya = input.askStr("--> Enter item name to replace from: ");
        Item temp = new Item(nomer, imya);
        if (memTracker.replace(nomer, temp)) {
            out.println("Item with id " + nomer + " update");
        } else {
            out.println("No such id");
        }
        return true;
    }
}
