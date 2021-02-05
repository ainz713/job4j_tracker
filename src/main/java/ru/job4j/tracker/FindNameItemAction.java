package ru.job4j.tracker;

public class FindNameItemAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Item by Name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String imya = input.askStr("Введите имя заявки, которую необходимо найти: ");
        Item[] massiv = tracker.findByName(imya);
        if (massiv.length != 0) {
            for (int i = 0; i < massiv.length; i++) {
                System.out.println(massiv[i]);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
