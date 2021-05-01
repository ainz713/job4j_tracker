package ru.job4j.tracker;

public class FindIdItemAction implements UserAction {
    private final Output out;

    public FindIdItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find Item by Id ====";
    }

    @Override
    public boolean execute(Input input, MemTracker memTracker) {
        int nomer = input.askInt("Введите id заявки, которую необходимо найти: ");
        Item temp = memTracker.findById(nomer);
        if (temp != null) {
            out.println("Ваша заявка: " + temp);
        } else {
            out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
