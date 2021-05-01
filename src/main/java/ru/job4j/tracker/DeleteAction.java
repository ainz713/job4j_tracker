package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, MemTracker memTracker) {
        int nomer = input.askInt("Введите id заявки, которую необходимо удалить: ");
        if (memTracker.delete(nomer)) {
            out.println("Заявка удалена");
        } else {
            out.println("Что-то пошло не так, попробуйте еще раз");
        }
        return true;
    }
}
