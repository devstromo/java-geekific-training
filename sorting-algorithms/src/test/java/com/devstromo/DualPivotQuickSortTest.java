package com.devstromo;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class DualPivotQuickSortTest {

    @Test
    public void testDualPivotSorting(){
        Integer[] integers = { 10, 55, -5, 34, 7, 22, 19 };
        String[] strings = { "Void Elf", "Vulpera", "Human", "Troll", "Undead" };
        out.print(Arrays.toString(integers) + " | " + Arrays.toString(strings));
        new DualPivotQuickSort<>(integers).sort();
        new DualPivotQuickSort<>(strings).sort();
        out.print(Arrays.toString(integers) + " | " + Arrays.toString(strings));
        assertEquals("[-5, 7, 10, 19, 22, 34, 55]", (Arrays.toString(integers)));
        assertEquals("[Human, Troll, Undead, Void Elf, Vulpera]", (Arrays.toString(strings)));
    }


}