package ru.job4j.tracker;

public class StartUI {

//    public static void createItem(Input input, Tracker tracker) {
//        System.out.println("=== Create a new Item ====");
//        String name = input.askStr("Enter name: ");
//        Item item = new Item(name);
//        tracker.add(item);
//    }
//
//    public static void replaceItem(Input input, Tracker tracker) {
//        int nomer = input.askInt("Введите id заявки: ");
//        String imya = input.askStr("Введите имя изменяемой заявки: ");
//        Item temp = new Item(imya);
//        if (tracker.replace(nomer, temp)) {
//            System.out.println("Заявка изменена");
//        } else {
//            System.out.println("Что-то пошло не так, попробуйте еще раз");
//        }
//    }
//
//    public static void deleteItem(Input input, Tracker tracker) {
//        int nomer = input.askInt("Введите id заявки, которую необходимо удалить: ");
//        if (tracker.delete(nomer)) {
//            System.out.println("Заявка удалена");
//        } else {
//            System.out.println("Что-то пошло не так, попробуйте еще раз");
//        }
//    }
//
//    public static void findAllItem(Input input, Tracker tracker) {
//        Item[] massiv = tracker.findAll();
//        for (int i = 0; i < massiv.length; i++) {
//            System.out.println(massiv[i]);
//        }
//    }
//
//    public static void findbyIdItem(Input input, Tracker tracker) {
//        int nomer = input.askInt("Введите id заявки, которую необходимо найти: ");
//        Item temp = tracker.findById(nomer);
//        if (temp != null) {
//            System.out.println("Ваша заявка: " + temp);
//        } else {
//            System.out.println("Заявка с таким id не найдена");
//        }
//    }
//
//    public static void findbyNameItem(Input input, Tracker tracker) {
//        String imya = input.askStr("Введите имя заявки, которую необходимо найти: ");
//        Item[] massiv = tracker.findByName(imya);
//        if (massiv.length != 0) {
//            for (int i = 0; i < massiv.length; i++) {
//                System.out.println(massiv[i]);
//            }
//        } else {
//            System.out.println("Заявки с таким именем не найдены");
//        }
//    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
            boolean run = true;
            while (run) {
                this.showMenu(actions);
                int select = input.askInt("Select: ");
                UserAction action = actions[select];
                run = action.execute(input, tracker);
//                if (select == 0) {
//                    StartUI.createItem(input, tracker);
//                } else if (select == 1) {
//                    StartUI.findAllItem(input, tracker);
//                } else if (select == 2) {
//                    StartUI.replaceItem(input, tracker);
//                } else if (select == 3) {
//                    StartUI.deleteItem(input, tracker);
//                } else if (select == 4) {
//                  StartUI.findbyIdItem(input, tracker);
//                } else if (select == 5) {
//                    StartUI.findbyNameItem(input, tracker);
//                } else if (select == 6) {
//                    run = false;
//                }
            }
        }

        private void showMenu(UserAction[] actions) {
            System.out.println("Menu.");
            for (int index = 0; index < actions.length; index++) {
                System.out.println(index + ". " + actions[index].name());
            }
        }

        public static void main(String[] args) {
            Input input = new ConsoleInput();
            Tracker tracker = new Tracker();
            UserAction[] actions = {
                    new CreateAction(),
                    new FindAllItemsAction(),
                    new ReplaceAction(),
                    new DeleteAction(),
                    new FindIdItemAction(),
                    new FindNameItemAction(),
                    new ExitAction()
            };
            new StartUI().init(input, tracker, actions);
        }
    }

