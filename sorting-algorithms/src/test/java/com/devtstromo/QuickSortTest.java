package com.devtstromo;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class QuickSortTest {

    @Test
    public void testQuickSort() {
        Integer[] integers = { 10, 55, -5, 34, 7, 22, 19 };
        String[] strings = { "Void Elf", "Vulpera", "Human", "Troll", "Undead" };
        out.println(Arrays.toString(integers) + " | " + Arrays.toString(strings));
        new QuickSort<>(integers).sort();
        new QuickSort<>(strings).sort();
        out.println(Arrays.toString(integers) + " | " + Arrays.toString(strings));
        assertEquals("[-5, 7, 10, 19, 22, 34, 55]", (Arrays.toString(integers)));
        assertEquals("[Human, Troll, Undead, Void Elf, Vulpera]", (Arrays.toString(strings)));
    }

}