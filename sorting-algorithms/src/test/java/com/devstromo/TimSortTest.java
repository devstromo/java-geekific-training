package com.devstromo;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class TimSortTest {

    @Test
    public void testTimSort() {
        Integer[] integers = { 10, 55, -5, 34, 7, 22, 19, 27, -87, 12, 9, 41, -67, -32, 92, 17, 23, 45, -22, 29 };
        String[] strings = { "Tyron", "Arya", "Daenerys", "Sansa", "Cersei" };
        out.print(Arrays.toString(integers) + " | " + Arrays.toString(strings));
        new TimSort<>(integers).sort();
        new TimSort<>(strings).sort();
        out.print(Arrays.toString(integers) + " | " + Arrays.toString(strings));
        assertEquals("[-87, -67, -32, -22, -5, 7, 9, 10, 12, 17, 19, 22, 23, 27, 29, 34, 41, 45, 55, 92]", Arrays.toString(integers));
        assertEquals("[Arya, Cersei, Daenerys, Sansa, Tyron]", Arrays.toString(strings));
    }
}
