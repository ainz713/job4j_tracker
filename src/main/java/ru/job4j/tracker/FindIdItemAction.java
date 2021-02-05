package ru.job4j.tracker;

public class FindIdItemAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int nomer = input.askInt("Введите id заявки, которую необходимо найти: ");
        Item temp = tracker.findById(nomer);
        if (temp != null) {
            System.out.println("Ваша заявка: " + temp);
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
