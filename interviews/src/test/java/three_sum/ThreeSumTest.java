package three_sum;

import static java.util.Arrays.sort;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ThreeSumTest {

    @Test
    public void testThreeSum() {
        var input = new int[] { 2, 8, 4, 6, 1, 78, 12, 45, 19 };
        var expected = new int[] { 2, 8, 1 };
        var result = ThreeSum.threeSum(input, 11)
          .stream()
          .mapToInt(i -> i)
          .toArray();
        sort(result);
        sort(expected);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testThreeSumWithPointer() {
        var input = new int[] { 2, 8, 4, 6, 1, 78, 12, 45, 19 };
        var expected = new int[] { 2, 8, 1 };
        var result = ThreeSum.threeSumThreePointers(input, 11)
          .stream()
          .mapToInt(i -> i)
          .toArray();
        sort(result);
        sort(expected);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testThreeSumLeetCode() {
        var input = new int[] { -1, 0, 1, 2, -1, -4 };
        var result = ThreeSum.threeSumLeetCode(input);
        var firstExpected = new int[] { -1, -1, 2 };
        var secondExpected = new int[] { -1, 0, 1 };
        assertEquals(2, result.size());
        var firstResult = result.get(0)
          .stream()
          .mapToInt(i -> i)
          .toArray();
        sort(firstResult);
        sort(firstExpected);
        assertArrayEquals(firstExpected, firstResult);
        var secondResult = result.get(1)
          .stream()
          .mapToInt(i -> i)
          .toArray();
        sort(secondResult);
        sort(secondExpected);
        assertArrayEquals(secondExpected, secondResult);
    }

    @Test
    public void testThreeSumLeetCodeNotTriplet() {
        var input = new int[] { 0, 1, 1 };
        var result = ThreeSum.threeSumLeetCode(input);
        var firstExpected = new int[] { -1, -1, 2 };
        var secondExpected = new int[] { -1, 0, 1 };
        assertEquals(0, result.size());
    }

    @Test
    public void testThreeSumLeetCodeAllZeros() {
        var input = new int[] { 0, 0, 0 };
        var result = ThreeSum.threeSumLeetCode(input);
        var expected = new int[] { 0, 0, 0 };
        assertEquals(1, result.size());
        var resultValue = result.get(0)
          .stream()
          .mapToInt(i -> i)
          .toArray();
        assertArrayEquals(expected, resultValue);

    }

}