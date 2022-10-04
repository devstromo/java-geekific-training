package com.devstromo;

import static java.lang.System.in;
import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class MergeSortTest {

    @Test
    public void testMergeSort() {
        Integer[] integers = { 10, 55, -5, 34, 7, 22, 19 };
        String[] strings = { "Void Elf", "Vulpera", "Human", "Troll", "Undead" };
        out.print(Arrays.toString(integers) + " | " + Arrays.toString(strings));
        new MergeSort<>(integers).sort();
        new MergeSort<>(strings).sort();
        out.print(Arrays.toString(integers) + " | " + Arrays.toString(strings));
        assertEquals("[-5, 7, 10, 19, 22, 34, 55]", (Arrays.toString(integers)));
        assertEquals("[Human, Troll, Undead, Void Elf, Vulpera]", (Arrays.toString(strings)));
    }
}
