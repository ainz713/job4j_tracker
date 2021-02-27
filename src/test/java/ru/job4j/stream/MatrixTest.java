package ru.job4j.stream;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {

    @Test
    public void whenToFlatMap() {
        Integer[][] matrix = new Integer[2][2];
            matrix[0][0] = 1;
            matrix[0][1] = 2;
            matrix[1][0] = 3;
            matrix[1][1] = 4;
        Matrix m = new Matrix();
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(m.mapflatmap(matrix), is(expected));
    }
}