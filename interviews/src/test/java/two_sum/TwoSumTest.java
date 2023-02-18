package two_sum;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class TwoSumTest {

    @Test
    public void testTwoSum() {
        var input = new int[] { 2, 8, 4, 6, 1, 78, 12, 45, 19 };
        var expected = new int[] { 1, 78 };
        assertArrayEquals(expected, TwoSum.twoSum(input, 79));
    }

    @Test
    public void testTwoSumIndex() {
        var input = new int[] { 2, 8, 4, 6, 1, 78, 12, 45, 19 };
        var expected = new int[] { 4, 5 };
        assertArrayEquals(expected, TwoSum.twoSumIndexes(input, 79));
    }

    @Test
    public void testTwoSumNotFound() {
        var input = new int[] { 2, 8, 4, 6, 1, 78, 12, 45, 19 };
        var expected = new int[] { 0, 0 };
        assertArrayEquals(expected, TwoSum.twoSum(input, 145));
    }

    @Test
    public void testTwoSumIndexNotFound() {
        var input = new int[] { 2, 8, 4, 6, 1, 78, 12, 45, 19 };
        var expected = new int[] { 0, 0 };
        assertArrayEquals(expected, TwoSum.twoSumIndexes(input, 145));
    }

}