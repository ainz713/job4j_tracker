package ru.job4j.tracker;

import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() throws SQLException {
        Store tracker = new SqlTracker();
        tracker.init();
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        List<UserAction> actions = new ArrayList<>();
                actions.add(new CreateAction(out));
                actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Create a new Item%n"
                                + "1. Exit Program%n"
                                + "New item created%n"
                                + "Menu.%n"
                                + "0. Create a new Item%n"
                                + "1. Exit Program%n"
                )
        ));
    }

    @Test
        public void whenShowItem() throws SQLException {
        Store tracker = new SqlTracker();
        tracker.init();
            Output out = new StubOutput();
            List<Item> item = tracker.findAll();
            StringBuilder s = new StringBuilder();
        for (Item e
                :item) {
            s.append(e).append(System.lineSeparator());
        }
            Input in = new StubInput(
                    new String[]{"0", "1"}
            );
            List<UserAction> actions = Arrays.asList(
                    new ShowItemAction(out),
                    new ExitAction(out)
            );
            new StartUI(out).init(in, tracker, actions);
            assertThat(out.toString(), is(
                    String.format(
                            "Menu.%n"
                                    + "0. Show all items%n"
                                    + "1. Exit Program%n"
                                    + s
                                    + "Menu.%n"
                                    + "0. Show all items%n"
                                    + "1. Exit Program%n"
                    )
            ));
        }

    @Test
        public void whenNotShowItem() throws SQLException {
        Store tracker = new SqlTracker();
        tracker.init();
            Output out = new StubOutput();
            Input in = new StubInput(
                    new String[]{"0", "1"}
            );
        List<Item> item = tracker.findAll();
        for (Item e
                :item) {
            tracker.delete(e.getId());
        }
            List<UserAction> actions = Arrays.asList(
                    new ShowItemAction(out),
                    new ExitAction(out)
            );
            new StartUI(out).init(in, tracker, actions);
            assertThat(out.toString(), is(
                    String.format(
                            "Menu.%n"
                                    + "0. Show all items%n"
                                    + "1. Exit Program%n"
                                    + "No items to show%n"
                                    + "Menu.%n"
                                    + "0. Show all items%n"
                                    + "1. Exit Program%n"
                    )
            ));
        }

    @Test
        public void whenReplaceItem() throws SQLException {
        Store tracker = new SqlTracker();
        tracker.init();
            Output out = new StubOutput();
            Item item = tracker.add(new Item("Replaced item"));
            String replacedName = "New item name";
            Input in = new StubInput(
                    new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
            );
            List<UserAction> actions = Arrays.asList(
                    new ReplaceAction(out),
                    new ExitAction(out)
            );
            new StartUI(out).init(in, tracker, actions);
            assertThat(out.toString(), is(
                    String.format(
                            "Menu.%n"
                                    + "0. Replace item%n"
                                    + "1. Exit Program%n"
                                    + "Item with id " + item.getId()
                                    + " update%n"
                                    + "Menu.%n"
                                    + "0. Replace item%n"
                                    + "1. Exit Program%n"
                    )
            ));
        }

    @Test
        public void whenDeleteItem() throws SQLException {
        Store tracker = new SqlTracker();
        tracker.init();
            Output out = new StubOutput();
            Item item = tracker.add(new Item("Deleted item"));
            Input in = new StubInput(
                    new String[]{"0", String.valueOf(item.getId()), "1"}
            );
            List<UserAction> actions = Arrays.asList(
                    new DeleteAction(out),
                    new ExitAction(out)
            );
            new StartUI(out).init(in, tracker, actions);
            assertThat(out.toString(), is(
                    String.format(
                            "Menu.%n"
                                    + "0. Delete Item%n"
                                    + "1. Exit Program%n"
                                    + "Item with id " + item.getId()
                                    + " deleted%n"
                                    + "Menu.%n"
                                    + "0. Delete Item%n"
                                    + "1. Exit Program%n"
                    )
            ));
        }

    @Test
        public void whenNotDeleteItem() throws SQLException {
        Store tracker = new SqlTracker();
        tracker.init();
            Output out = new StubOutput();
            Item item = tracker.add(new Item("Deleted item"));
            Input in = new StubInput(
                    new String[]{"0", String.valueOf(item.getId() + 1), "1"}
            );
            List<UserAction> actions = Arrays.asList(
                    new DeleteAction(out),
                    new ExitAction(out)
            );
            new StartUI(out).init(in, tracker, actions);
            assertThat(out.toString(), is(
                    String.format(
                            "Menu.%n"
                                    + "0. Delete Item%n"
                                    + "1. Exit Program%n"
                                    + "No such id%n"
                                    + "Menu.%n"
                                    + "0. Delete Item%n"
                                    + "1. Exit Program%n"
                    )
            ));
        }

    @Test
        public void whenFindItemId() throws SQLException {
        Store tracker = new SqlTracker();
        tracker.init();
            Output out = new StubOutput();
            Item item = tracker.add(new Item("Item"));
            Input in = new StubInput(
                    new String[]{"0", String.valueOf(item.getId()), "1"}
            );
            List<UserAction> actions = Arrays.asList(
                    new FindIdItemAction(out),
                    new ExitAction(out)
            );
            new StartUI(out).init(in, tracker, actions);
            assertThat(out.toString(), is(
                    String.format(
                            "Menu.%n"
                                    + "0. Find item by id%n"
                                    + "1. Exit Program%n"
                                    + item.toString() + "%n"
                                    + "Menu.%n"
                                    + "0. Find item by id%n"
                                    + "1. Exit Program%n"
                    )
            ));
        }

    @Test
        public void whenNotFindItemId() throws SQLException {
        Store tracker = new SqlTracker();
        tracker.init();
            Output out = new StubOutput();
            Item item = tracker.add(new Item("Item"));
            Input in = new StubInput(
                    new String[]{"0", String.valueOf(item.getId() + 1), "1"}
            );
            List<UserAction> actions = Arrays.asList(
                    new FindIdItemAction(out),
                    new ExitAction(out)
            );
            new StartUI(out).init(in, tracker, actions);
            assertThat(out.toString(), is(
                    String.format(
                            "Menu.%n"
                                    + "0. Find item by id%n"
                                    + "1. Exit Program%n"
                                    + "No such item with id "
                                    + (item.getId() + 1) + "%n"
                                    + "Menu.%n"
                                    + "0. Find item by id%n"
                                    + "1. Exit Program%n"
                    )
            ));
        }

    @Test
        public void whenFindItemName() throws SQLException {
        Store tracker = new SqlTracker();
        tracker.init();
            Output out = new StubOutput();
            Item item = tracker.add(new Item("Item1"));
            String name = "Item1";
            Input in = new StubInput(
                    new String[]{"0", name, "1"}
            );
            List<UserAction> actions = Arrays.asList(
                    new FindNameItemAction(out),
                    new ExitAction(out)
            );
            new StartUI(out).init(in, tracker, actions);
            assertThat(out.toString(), is(
                    String.format(
                            "Menu.%n"
                                    + "0. Find item by name%n"
                                    + "1. Exit Program%n"
                                    + item.toString() + "%n"
                                    + "Menu.%n"
                                    + "0. Find item by name%n"
                                    + "1. Exit Program%n"
                    )
            ));
        }

    @Test
        public void whenNotFindItemName() throws SQLException {
        Store tracker = new SqlTracker();
        tracker.init();
            Output out = new StubOutput();
            String name = "Item2";
            Input in = new StubInput(
                    new String[]{"0", name, "1"}
            );
            List<UserAction> actions = Arrays.asList(
                    new FindNameItemAction(out),
                    new ExitAction(out)
            );
            new StartUI(out).init(in, tracker, actions);
            assertThat(out.toString(), is(
                    String.format(
                            "Menu.%n"
                                    + "0. Find item by name%n"
                                    + "1. Exit Program%n"
                                    + "No such item with name "
                                    + "\"" + name + "\"" + "%n"
                                    + "Menu.%n"
                                    + "0. Find item by name%n"
                                    + "1. Exit Program%n"
                    )
            ));
        }

    @Test
        public void whenExit() throws SQLException {
        Store tracker = new SqlTracker();
        tracker.init();
            Output out = new StubOutput();
            Input in = new StubInput(
                    new String[]{"1", "0"}
            );
            List<UserAction> actions = new ArrayList<>();
            actions.add(new ExitAction(out));
            new StartUI(out).init(in, tracker, actions);
            assertThat(out.toString(), is(
                    String.format(
                            "Menu.%n"
                                    + "0. Exit Program%n"
                                    + "Wrong input, you can select: 0 .. 0%n"
                                    + "Menu.%n"
                                    + "0. Exit Program%n"
                    )
            ));
        }
}