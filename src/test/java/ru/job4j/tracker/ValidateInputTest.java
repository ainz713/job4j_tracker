package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenRightInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenManyInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Select: ");
        assertThat(selected, is(1));
    }

    @Test
    public void whenNegativeInput() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        Input in = new StubInput(
                new String[] {"-1", "0"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0. === Exit Program ====" + System.lineSeparator()
        ));
    }
}