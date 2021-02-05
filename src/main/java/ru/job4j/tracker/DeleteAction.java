package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int nomer = input.askInt("Введите id заявки, которую необходимо удалить: ");
        if (tracker.delete(nomer)) {
            System.out.println("Заявка удалена");
        } else {
            System.out.println("Что-то пошло не так, попробуйте еще раз");
        }
        return true;
    }
}
