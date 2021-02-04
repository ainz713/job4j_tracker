package ru.job4j.tracker;


public class StartUI {
        public void init(Input input, Tracker tracker) {
            boolean run = true;
            while (run) {
                this.showMenu();
                int select = input.askInt("Select: ");
                if (select == 0) {
                    System.out.println("=== Create a new Item ====");
                    String name = input.askStr("Enter name: ");
                    Item item = new Item(name);
                    tracker.add(item);
                } else if (select == 1) {
                    Item[] massiv = tracker.findAll();
                    for (int i = 0; i < massiv.length; i++) {
                        System.out.println(massiv[i]);
                    }
                } else if (select == 2) {
                    int nomer = input.askInt("Введите id заявки: ");
                    String imya = input.askStr("Введите имя изменяемой заявки: ");
                    Item temp = new Item(imya);
                    if (tracker.replace(nomer, temp)) {
                        System.out.println("Заявка изменена");
                    } else {
                        System.out.println("Что-то пошло не так, попробуйте еще раз");
                    }
                } else if (select == 3) {
                    int nomer = input.askInt("Введите id заявки, которую необходимо удалить: ");
                    if (tracker.delete(nomer)) {
                        System.out.println("Заявка удалена");
                    } else {
                        System.out.println("Что-то пошло не так, попробуйте еще раз");
                    }
                } else if (select == 4) {
                    int nomer = input.askInt("Введите id заявки, которую необходимо найти: ");
                    Item temp = tracker.findById(nomer);
                    if (temp != null) {
                        System.out.println("Ваша заявка: " + temp);
                    } else {
                        System.out.println("Заявка с таким id не найдена");
                    }
                } else if (select == 5) {
                    String imya = input.askStr("Введите имя заявки, которую необходимо найти: ");
                    Item[] massiv = tracker.findByName(imya);
                    if (massiv.length != 0) {
                        for (int i = 0; i < massiv.length; i++) {
                            System.out.println(massiv[i]);
                        }
                    } else {
                        System.out.println("Заявки с таким именем не найдены");
                    }
                } else if (select == 6) {
                    run = false;
                }
            }
        }

        private void showMenu() {
            System.out.println("Menu.");
            System.out.println("0. Add new Item");
            System.out.println("1. Show all items");
            System.out.println("2. Edit item");
            System.out.println("3. Delete item");
            System.out.println("4. Find item by Id");
            System.out.println("5. Find items by name");
            System.out.println("6. Exit Program");
            /* добавить остальные пункты меню. */
        }

        public static void main(String[] args) {
            Input input = new ConsoleInput();
            Tracker tracker = new Tracker();
            new StartUI().init(input, tracker);
        }
    }

