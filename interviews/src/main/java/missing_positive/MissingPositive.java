package missing_positive;

import java.util.Arrays;
import java.util.HashSet;

public class MissingPositive {
    // O(n^2)
    public int missingNumber(int[] nums) {
        var list = Arrays.stream(nums).boxed().toList();
        int i = 0;
        while (true) {
            if (!list.contains(i)) return i;
            i++;
        }
    }

    // O(n)
    public int missingNumberSets(int[] nums) {
        var set = new HashSet<>(Arrays.stream(nums).boxed().toList());
        int i = 0;
        while (true) {
            if (!set.contains(i)) return i;
            i++;
        }
    }

    // O(n.logn)
    public int missingNumberSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums.length;
    }

    // O(n)
    // Gauss Summation
    public int missingNumberGaussSum(int[] nums) {
        int n = nums.length;
        int expected = n * (n + 1) / 2;
        int actual = Arrays.stream(nums).sum();
        return expected - actual;
    }

    /*
     * First missing smallest positive
     */
    // O(n)
    public int firstMissingPositive(int[] nums) {
        var set = new HashSet<>(Arrays.stream(nums).boxed().toList());
        int i = 1;
        while (true) {
            if (!set.contains(i)) return i;
            i++;
        }
    }

    public int firstMissingPositiveNegativeMarking(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) nums[i] = n + 1;
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > 0 && num <= n) {
                nums[num - 1] = -Math.abs(nums[n - 1]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return i + 1;
        }
        return n + 1;
    }

}
