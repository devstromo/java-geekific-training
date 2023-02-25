package three_sum;

import static java.util.Arrays.sort;
import static two_sum.TwoSum.twoSum;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {

    // O(n^2)
    public static List<Integer> threeSum(int[] nums, int target) {
        for (int start = 0; start < nums.length; start++) {
            var result = twoSum(nums, target - nums[start], start);
            if (!result.isEmpty()) {
                return List.of(result.get(0), result.get(1), nums[start]);
            }
        }
        return Collections.emptyList();
    }

    // O(n^2)
    public static List<Integer> threeSumThreePointers(int[] nums, int target) {
        sort(nums);
        for (int left = 0; left < nums.length - 2; left++) {
            var middle = left + 1;
            var right = nums.length - 1;
            while (middle < right) {
                var sum = nums[middle] + nums[right] + nums[left];
                if (sum == target) {
                    return List.of(nums[left], nums[middle], nums[right]);
                }
                if (sum > target) {
                    // for continuous repetitions
                    do
                        right--; while (middle < right && nums[right] == nums[right + 1]);
                } else {
                    do
                        middle++; while (middle < right && nums[middle] == nums[middle - 1]);
                }
            }
        }
        return Collections.emptyList();
    }

    // https://leetcode.com/problems/3sum/
    public static List<List<Integer>> threeSumLeetCode(int[] nums) {
        sort(nums);
        var result = new HashSet<List<Integer>>();
        for (int left = 0; left < nums.length - 2; left++) {
            var middle = left + 1;
            var right = nums.length - 1;
            while (middle < right) {
                var sum = nums[middle] + nums[right] + nums[left];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[left], nums[middle], nums[right]));
                }
                if (sum > 0) {
                    // for continuous repetitions
                    do
                        right--; while (middle < right && nums[right] == nums[right + 1]);
                } else {
                    do
                        middle++; while (middle < right && nums[middle] == nums[middle - 1]);
                }
            }
        }
        return result.stream()
          .toList();
    }
}
