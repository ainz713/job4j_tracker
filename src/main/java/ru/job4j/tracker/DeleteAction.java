package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        int nomer = input.askInt("--> Enter item id: ");
        if (memTracker.delete(nomer)) {
            out.println("Item with id " + nomer + " deleted");
        } else {
            out.println("No such id");
        }
        return true;
    }
}
