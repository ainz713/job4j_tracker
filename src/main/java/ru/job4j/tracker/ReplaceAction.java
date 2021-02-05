package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Edit Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int nomer = input.askInt("Введите id заявки: ");
        String imya = input.askStr("Введите имя изменяемой заявки: ");
        Item temp = new Item(imya);
        if (tracker.replace(nomer, temp)) {
            out.println("Заявка изменена");
        } else {
            out.println("Что-то пошло не так, попробуйте еще раз");
        }
        return true;
    }
}
