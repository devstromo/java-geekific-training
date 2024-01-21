package missing_positive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MissingPositiveUnitTest {
    private final MissingPositive missingPositive = new MissingPositive();

    @Test
    void testMissingPositive() {
        var nums = new int[]{2, 10, 3, 5, 8, 7, 9, 4, 1, 0};
        assertEquals(6, missingPositive.missingNumber(nums));
    }

    @Test
    void testMissingPositiveSets() {
        var nums = new int[]{2, 10, 3, 5, 8, 7, 9, 4, 1, 0};
        assertEquals(6, missingPositive.missingNumberSets(nums));
    }

    @Test
    void testMissingPositiveSort() {
        var nums = new int[]{2, 10, 3, 5, 8, 7, 9, 4, 1, 0};
        assertEquals(6, missingPositive.missingNumberSort(nums));
    }

    @Test
    void testMissingPositiveGauss() {
        var nums = new int[]{2, 10, 3, 5, 8, 7, 9, 4, 1, 0};
        assertEquals(6, missingPositive.missingNumberGaussSum(nums));
    }

    @Test
    void testFirstMissingSmallestPositive() {
        var nums = new int[]{2, 10, 3, 5, -8, 7, 19, 4, 21, -1};
        assertEquals(1, missingPositive.firstMissingPositive(nums));
    }

    @Test
    void testFirstMissingSmallestPositiveNegativeMarking() {
        var nums = new int[]{2, 10, 3, 5, -8, 7, 19, 4, 21, -1};
        assertEquals(1, missingPositive.firstMissingPositiveNegativeMarking(nums));
    }
}