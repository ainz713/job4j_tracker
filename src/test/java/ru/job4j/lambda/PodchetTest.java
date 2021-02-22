package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PodchetTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        Podchet function = new Podchet();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadratichnayaFunctionThenLinearResults() {
        Podchet function = new Podchet();
        List<Double> result = function.diapason(5, 8, x -> x * x + 1);
        List<Double> expected = Arrays.asList(26D, 37D, 50D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenPokazatelnayaFunctionThenLinearResults() {
        Podchet function = new Podchet();
        List<Double> result = function.diapason(2, 5, x -> Math.pow(x, x));
        List<Double> expected = Arrays.asList(4D, 27D, 256D);
        assertThat(result, is(expected));
    }
}