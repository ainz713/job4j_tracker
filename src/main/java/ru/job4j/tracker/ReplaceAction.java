package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
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
            System.out.println("Заявка изменена");
        } else {
            System.out.println("Что-то пошло не так, попробуйте еще раз");
        }
        return true;
    }
}
