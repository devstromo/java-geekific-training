package contains_duplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class ContainsDuplicate {

    // O(n)
    public static boolean containsDuplicate(int[] nums) {
        return nums.length != Arrays.stream(nums)
          .boxed()
          .collect(Collectors.toSet())
          .size();
    }

    public static boolean containsDuplicates(int[] nums) {
        var set = new HashSet<Integer>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicates(int[] nums, int k) {
        var set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.size() > k)
                set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) {
                return true;
            }
        }

        return false;
    }
}
