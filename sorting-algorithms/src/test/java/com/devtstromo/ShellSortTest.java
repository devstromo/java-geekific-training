package com.devtstromo;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ShellSortTest {
    @Test
    public void testTimSort() {
        Integer[] integers = { 10, 55, -5, 34, 7, 22, 19 };
        String[] strings = { "Tyron", "Arya", "Daenerys", "Sansa", "Cersei" };
        out.println(Arrays.toString(integers) + " | " + Arrays.toString(strings));
        new ShellSort<>(integers).sort();
        new ShellSort<>(strings).sort();
        out.println(Arrays.toString(integers) + " | " + Arrays.toString(strings));
        assertEquals("[-5, 7, 10, 19, 22, 34, 55]", Arrays.toString(integers));
        assertEquals("[Arya, Cersei, Daenerys, Sansa, Tyron]", Arrays.toString(strings));
    }

    @Test
    public void testTimSortRecursive() {
        Integer[] integers = { 10, 55, -5, 34, 7, 22, 19 };
        String[] strings = { "Tyron", "Arya", "Daenerys", "Sansa", "Cersei" };
        out.println(Arrays.toString(integers) + " | " + Arrays.toString(strings));
        new ShellSort<>(integers).sortRecursive();
        new ShellSort<>(strings).sortRecursive();
        out.println(Arrays.toString(integers) + " | " + Arrays.toString(strings));
        assertEquals("[-5, 7, 10, 19, 22, 34, 55]", Arrays.toString(integers));
        assertEquals("[Arya, Cersei, Daenerys, Sansa, Tyron]", Arrays.toString(strings));
    }

}