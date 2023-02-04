package intersection_arrays;

import static java.util.Arrays.sort;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class IntersectionArraysTest {

    @Test
    public void testIntersectionWithSet() {
        assertArrayEquals(new int[] { 2, 3 },
          IntersectionArrays.intersectionWithSet(new int[] { 100, 1, 2, 2, 3, 3, 4, 4, 5, 6 }, new int[] { 10, 11, 19, 18, 16, 13, 57, 2, 54, 78, 65, 3 }));
    }

    @Test
    public void testIntersectionWithSetRetainAll() {
        assertArrayEquals(new int[] { 2, 3 }, IntersectionArrays.intersectionWithRetainAll(new int[] { 100, 1, 2, 2, 3, 3, 4, 4, 5, 6 },
          new int[] { 10, 11, 19, 18, 16, 13, 57, 2, 54, 78, 65, 3 }));
    }

    @Test
    public void testIntersectionWithMap() {
        assertArrayEquals(new int[] { 2, 3 },
          IntersectionArrays.intersectionWithMaps(new int[] { 100, 1, 2, 2, 3, 3, 4, 4, 5, 6 }, new int[] { 10, 11, 19, 18, 16, 13, 57, 2, 54, 78, 65, 3 }));
    }

    @Test
    public void testIntersectionWithSortedArray() {
        var result = new int[] { 2, 3 };
        var nums1 = new int[] { 100, 1, 2, 2, 3, 3, 4, 4, 5, 6 };
        var nums2 = new int[] { 10, 11, 19, 18, 16, 13, 57, 2, 54, 78, 65, 3 };
        sort(nums1);
        sort(nums2);
        assertArrayEquals(result, IntersectionArrays.intersectionWithSortedArrays(nums1, nums2));
    }

    @Test
    public void testIntersectionWithBinarySearch() {
        var result = new int[] { 2, 3 };
        var nums1 = new int[] { 100, 1, 2, 2, 3, 3, 4, 4, 5, 6 };
        var nums2 = new int[] { 10, 11, 19, 18, 16, 13, 57, 2, 54, 78, 65, 3 };
        sort(nums1);
        assertArrayEquals(result, IntersectionArrays.intersectionWithSortedArraysAndBinarySearch(nums1, nums2));
    }

}