package find_duplicates;

import static java.lang.Math.abs;

import java.util.HashSet;

public class FindDuplicate {

    public static int findDuplicate(int[] nums) {
        var set = new HashSet<Integer>();
        for (var num : nums) {
            if (!set.add(num))
                return num;
        }
        return -1;
    }

    // O(n) input array positive numbers between 0 and arr.length
    public static int findDuplicateWithNegativeMarking(int[] nums) {
        var duplicate = -1;
        var set = new HashSet<Integer>();
        for (var i = 0; i < nums.length; i++) {
            var cur = abs(nums[i]);
            if (nums[cur] < 0) {
                duplicate = cur;
                break;
            }
            nums[cur] *= -1;
        }
        for (var i = 0; i < nums.length; i++) {
            nums[i] = abs(nums[i]);
        }
        return duplicate;
    }

    // Tortoise and Hare Solution
    public static int findDuplicateWithFloyd(int[] nums) {
        var slow = nums[0];
        var fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}


