package two_pointers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class TwoPointersTest {

    @Test
    public void testTwoPointersInSum() {
        assertArrayEquals(new int[] { 1, 2 }, TwoPointers.twoSum(new int[] { 2, 7, 11, 15 }, 9));
        assertArrayEquals(new int[] { 1, 3 }, TwoPointers.twoSum(new int[] { 2, 3, 4 }, 6));
        assertArrayEquals(new int[] { 1, 2 }, TwoPointers.twoSum(new int[] { -1, 0 }, -1));
    }

}