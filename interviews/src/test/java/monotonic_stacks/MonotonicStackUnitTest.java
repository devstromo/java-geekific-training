package monotonic_stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonotonicStackUnitTest {

    private final MonotonicStack solution = new MonotonicStack();

    @Test
    void testDailyTemperatures() {
        var input = new int[]{58, 56, 61, 55, 57, 44, 40, 35, 46};
        var expected = new int[]{2, 1, 0, 1, 0, 3, 2, 1, 0};
        assertArrayEquals(expected, solution.dailyTemperature(input));
    }

    @Test
    void testDailyTemperaturesMonotonicStack() {
        var input = new int[]{58, 56, 61, 55, 57, 44, 40, 35, 46};
        var expected = new int[]{2, 1, 0, 1, 0, 3, 2, 1, 0};
        assertArrayEquals(expected, solution.dailyTemperatureMonotonicStack(input));
    }

    @Test
    void testNextGreaterElement() {
        var input = new int[]{3, 4, 9};
        var input2 = new int[]{2, 6, 3, 5, 8, 7, 9, 4, 11};
        var expected = new int[]{5, 11, 11};
        assertArrayEquals(expected, solution.nextGreaterElement(input, input2));
    }

    @Test
    void testNextGreaterElementWithMap() {
        var input = new int[]{3, 4, 9};
        var input2 = new int[]{2, 6, 3, 5, 8, 7, 9, 4, 11};
        var expected = new int[]{5, 11, 11};
        assertArrayEquals(expected, solution.nextGreaterElementMaps(input, input2));
    }

    @Test
    void testNextGreaterElementCircular() {
        var input = new int[]{58, 56, 61, 55, 57, 44, 40, 35, 46};
        var expected = new int[]{61, 61, -1, 57, 58, 46, 46, 46, 58};
        assertArrayEquals(expected, solution.nextGreaterElementCircular(input));
    }
}