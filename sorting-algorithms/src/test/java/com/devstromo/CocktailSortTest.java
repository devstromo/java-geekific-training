package com.devstromo;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class CocktailSortTest {

    @Test
    public void testCocktailSortInteger() {
        Integer[] input = new Integer[] { 42, 32, 63, 82, 37, 17, 51, 11, 22, 75 };
        Integer[] expected = new Integer[] { 11, 17, 22, 32, 37, 42, 51, 63, 75, 82 };
        new CocktailSort<>(input).sort();
        out.println(Arrays.toString(input));
        assertArrayEquals(expected, input);
//        assertEquals("[11, 17, 22, 32, 37, 42, 51, 63, 75, 82]", Arrays.toString(sortedArray.toArray()));
    }
}
