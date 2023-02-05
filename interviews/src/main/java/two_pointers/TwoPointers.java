package two_pointers;

public class TwoPointers {

    // array need to be sorted in non-decreasing order
    public static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target)
                left++;
            else if (sum > target) {
                right--;
            } else
                return new int[] { left + 1, right + 1 };
        }
        return new int[2];
    }
}
