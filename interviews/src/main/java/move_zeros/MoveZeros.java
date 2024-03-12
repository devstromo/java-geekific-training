package move_zeros;

import java.util.Arrays;

public class MoveZeros {

    // T: O(n^2)
    // S: O(1)
    public static int[] moveZerosBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] == 0) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    // T: O(n)
    // S: O(n)
    public static int[] moveZerosLinear(int[] nums) {
        var arr = new int[nums.length];
        var insertPos = 0;
        for (int num : nums) {
            if (num != 0) {
                arr[insertPos++] = num;
            }
        }

        System.arraycopy(arr, 0, nums, 0, nums.length);
        return arr;
    }
}
