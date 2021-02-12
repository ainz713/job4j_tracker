package ru.job4j.tracker;

import java.util.List;

public class FindNameItemAction implements UserAction {
    private final Output out;

    public FindNameItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find Item by Name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String imya = input.askStr("Введите имя заявки, которую необходимо найти: ");
        List<Item> massiv = tracker.findByName(imya);
        if (massiv.size() != 0) {
            for (int i = 0; i < massiv.size(); i++) {
                out.println(massiv.get(i));
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
