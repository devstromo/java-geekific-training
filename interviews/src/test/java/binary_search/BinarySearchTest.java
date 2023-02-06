package binary_search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @Test
    public void testBinarySearch() {
        int[] input = new int[] { 1, 2, 10, 11, 12, 15, 16 };
        assertEquals(2, BinarySearch.search(input, 10));
    }

    @Test
    public void testBinarySearchNotFound() {
        int[] input = new int[] { 1, 2, 10, 11, 12, 15, 16 };
        assertEquals(-1, BinarySearch.search(input, 100));
    }

    @Test
    public void testBinarySearchLeft() {
        int[] input = new int[] { 1, 2, 10, 11, 12, 12, 12, 12, 12, 12, 15, 15, 15, 15, 15, 15, 16 };
        assertEquals(4, BinarySearch.searchLeft(input, 12));
    }

    @Test
    public void testBinarySearchLeftNotFound() {
        int[] input = new int[] { 1, 2, 10, 11, 12, 12, 12, 12, 12, 12, 15, 15, 15, 15, 15, 15, 16 };
        assertEquals(-1, BinarySearch.searchLeft(input, 100));
    }

    @Test
    public void testBinarySearchRight() {
        int[] input = new int[] { 1, 2, 10, 11, 12, 12, 12, 12, 12, 12, 15, 15, 15, 15, 15, 15, 16 };
        assertEquals(15, BinarySearch.searchRight(input, 15));
    }

    @Test
    public void testBinarySearchRightNotFound() {
        int[] input = new int[] { 1, 2, 10, 11, 12, 12, 12, 12, 12, 12, 15, 15, 15, 15, 15, 15, 16 };
        assertEquals(-1, BinarySearch.searchRight(input, 100));
    }

}