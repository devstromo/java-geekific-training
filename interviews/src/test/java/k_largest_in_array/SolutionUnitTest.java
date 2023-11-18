package k_largest_in_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionUnitTest {
    private final Solution solution = new Solution();

    @Test
    public void testFindKthLargest() {
        assertEquals(4, solution.findKthLargest(new int[]{5, 4, 3, 2, 2, 1}, 2));
    }

    @Test
    public void testFindKthLargest1() {
        assertEquals(4, solution.findKthLargestMinimumHeap(new int[]{5, 4, 3, 2, 2, 1}, 2));
    }

}