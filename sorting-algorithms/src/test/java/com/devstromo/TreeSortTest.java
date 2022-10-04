package com.devstromo;

import static java.lang.System.out;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class TreeSortTest {

    @Test
    public void testTreeSort() {
        List<Integer> integers = asList(10, 55, -5, 34, 7, 22, 19);
        List<String> strings = asList("Void Elf", "Vulpera", "Human", "Troll", "Undead");
        out.println(integers + " | " + strings);
        new TreeSort<>(integers).sort();
        new TreeSort<>(strings).sort();
    }

    @Test
    public void testTreeSortList() {
        List<Integer> integers = asList(10, 55, -5, 34, 7, 22, 19);
        List<String>  strings= asList("Void Elf", "Vulpera", "Human", "Troll", "Undead");
        out.println(integers + " | " + strings);
        List<Integer> integers2 = new TreeSort<>(integers).sortList();
        List<String> strings2 = new TreeSort<>(strings).sortList();
        out.println(integers2 + " | " + strings2);
        assertEquals("[-5, 7, 10, 19, 22, 34, 55]", integers2.toString());
        assertEquals("[Human, Troll, Undead, Void Elf, Vulpera]", strings2.toString());
    }

}