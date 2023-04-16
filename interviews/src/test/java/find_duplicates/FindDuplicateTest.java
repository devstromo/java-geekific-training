package find_duplicates;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FindDuplicateUnitTest {
    @Test
    public void testFindDuplicate() {
        int[] nums1 = { 1, 3, 4, 2, 2 };
        int[] nums2 = { 3, 1, 3, 4, 2 };
        int[] nums3 = { 1, 1 };
        int[] nums4 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2 };
        int[] nums5 = { 1, 2, 3, 4, 5, 5, 6, 7, 8 };

        assertEquals(2, FindDuplicate.findDuplicate(nums1));
        assertEquals(3, FindDuplicate.findDuplicate(nums2));
        assertEquals(1, FindDuplicate.findDuplicate(nums3));
        assertEquals(2, FindDuplicate.findDuplicate(nums4));
        assertEquals(5, FindDuplicate.findDuplicate(nums5));
    }

    @Test
    public void testNoDuplicate() {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        assertEquals(-1, FindDuplicate.findDuplicate(nums));
    }

    @Test
    public void testFindDuplicateWithNegativeMarking() {
        int[] nums1 = {1, 3, 4, 2, 2};
        int[] nums2 = {3, 1, 3, 4, 2};
        int[] nums3 = {1, 1};
        int[] nums4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2};
        int[] nums5 = {1, 2, 3, 4, 5, 5, 6, 7, 8};

        assertEquals(2, FindDuplicate.findDuplicateWithNegativeMarking(nums1));
        assertEquals(3, FindDuplicate.findDuplicateWithNegativeMarking(nums2));
        assertEquals(1, FindDuplicate.findDuplicateWithNegativeMarking(nums3));
        assertEquals(2, FindDuplicate.findDuplicateWithNegativeMarking(nums4));
        assertEquals(5, FindDuplicate.findDuplicateWithNegativeMarking(nums5));
    }

    @Test
    public void testNoDuplicateWithNegativeMarking() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 7};

        assertEquals(7, FindDuplicate.findDuplicateWithNegativeMarking(nums));
    }

    @Test
    public void testFindDuplicateWithFloyd() {
        int[] nums1 = {1, 3, 4, 2, 2};
        int[] nums2 = {3, 1, 3, 4, 2};
        int[] nums3 = {1, 1};
        int[] nums4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2};
        int[] nums5 = {1, 2, 3, 4, 5, 5, 6, 7, 8};

        assertEquals(2, FindDuplicate.findDuplicateWithFloyd(nums1));
        assertEquals(3, FindDuplicate.findDuplicateWithFloyd(nums2));
        assertEquals(1, FindDuplicate.findDuplicateWithFloyd(nums3));
        assertEquals(2, FindDuplicate.findDuplicateWithFloyd(nums4));
        assertEquals(5, FindDuplicate.findDuplicateWithFloyd(nums5));
    }

}