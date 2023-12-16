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

}