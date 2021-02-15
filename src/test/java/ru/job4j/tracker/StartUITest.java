package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
                actions.add(new CreateAction(out));
                actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", "1", "New item name", "1"}
        );
        List<UserAction> actions = new ArrayList<>();
                actions.add(new ReplaceAction(out));
                actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Exit Program ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllAction() {
         Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New item name"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        List<UserAction> actions = new ArrayList<>();
                actions.add(new FindAllItemsAction(out));
                actions.add(new ExitAction(out));
        List<Item> massiv = tracker.findAll();
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                "0. === Show all Items ====" + System.lineSeparator() +
                        "1. === Exit Program ====" + System.lineSeparator() +
                        massiv.get(0) + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === Show all Items ====" + System.lineSeparator() +
                        "1. === Exit Program ====" + System.lineSeparator()
        ));
    }
    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New item name"));
        Input in = new StubInput(
                new String[] {"0", "New item name","1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindNameItemAction(out));
        actions.add(new ExitAction(out));
        List<Item> massiv = tracker.findAll();
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Find Item by Name ====" + System.lineSeparator() +
                        "1. === Exit Program ====" + System.lineSeparator() +
                        massiv.get(0) + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === Find Item by Name ====" + System.lineSeparator() +
                        "1. === Exit Program ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New item name"));
        Input in = new StubInput(
                new String[]{"0", "1", "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindIdItemAction(out));
        actions.add(new ExitAction(out));
        List<Item> massiv = tracker.findAll();
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Find Item by Id ====" + System.lineSeparator() +
                        "1. === Exit Program ====" + System.lineSeparator() +
                        "Ваша заявка: " + massiv.get(0) + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === Find Item by Id ====" + System.lineSeparator() +
                        "1. === Exit Program ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] { "9", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. === Exit Program ====%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. === Exit Program ====%n"
                )
        ));
    }
}