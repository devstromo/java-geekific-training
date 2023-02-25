package two_sum;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        var set = new HashSet<Integer>();
        for (var num : nums) {
            if (set.contains(target - num)) {
                return new int[] { target - num, num };
            }
            set.add(num);
        }
        return new int[2];
    }

    public static int[] twoSumIndexes(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        for (var i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }

    // user for three sum
    public static List<Integer> twoSum(int[] nums, int target, int start) {
        var set = new HashSet<Integer>();
        for (var i = start; i < nums.length; i++) {
            if (set.contains(target - nums[i])) {
                return List.of(target - nums[i], nums[i]);
            }
            set.add(nums[i]);
        }
        return Collections.emptyList();
    }
}
