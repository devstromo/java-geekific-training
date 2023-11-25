package robber_problem;

// House Robber problem
public class Solution {

    public int robRecursion(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return getMaxAmount(nums, nums.length - 1);
    }

    // O(n)
    public int robTabulation(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        dp[1] = Integer.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Integer.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public int rob(int[] nums) {
        int prev1 = 0, prev2 = 0;
        for (int num : nums) {
            int curr = Math.max(num + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    // Houses are arranged in circular order
    public int robCircular(int[] nums) {
        if (nums.length == 1) return nums[0];

        // rob first house or second house
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int low, int high) {
        int prev1 = 0, prev2 = 0;
        for (int i = low; i <= high; i++) {
            int curr = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    private int getMaxAmount(int[] nums, int n) {
        if (n < 0) return 0;
        if (n == 0) return nums[0];
        if (n == 1) return Integer.max(nums[1], nums[0]);
        return Integer.max(
                nums[n] + getMaxAmount(nums, n - 2),
                getMaxAmount(nums, n - 1)
        );
    }
}
