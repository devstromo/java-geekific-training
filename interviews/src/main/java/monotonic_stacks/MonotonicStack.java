package monotonic_stacks;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class MonotonicStack {

    public int[] dailyTemperature(int[] temperatures) {
        var result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    public int[] dailyTemperatureMonotonicStack(int[] temperatures) {
        var answer = new int[temperatures.length];
        var stack = new LinkedList<Integer>();
        for (int currentDay = 0; currentDay < temperatures.length; currentDay++) {
            var currentTemperature = temperatures[currentDay];
            while (!stack.isEmpty() && temperatures[stack.peek()] < currentTemperature) {
                var previousDay = stack.pop();
                answer[previousDay] = currentDay - previousDay;
            }
            stack.push(currentDay);
        }

        return answer;
    }

    // O(n*m)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            int k = 0;
            int current = nums1[i];
            while (k < nums2.length && current != nums2[k]) {
                k++;
            }
            while (k < nums2.length) {
                if (current < nums2[k]) {
                    nums1[i] = nums2[k];
                    break;
                } else {
                    nums1[i] = -1;
                }
                k++;
            }
        }
        return nums1;
    }

    public int[] nextGreaterElementMaps(int[] nums1, int[] nums2) {
        var map = new HashMap<Integer, Integer>();
        var stack = new LinkedList<Integer>();
        for (var num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

    public int[] nextGreaterElementCircular(int[] nums) {
        var result = IntStream.generate(() -> -1).limit(nums.length).toArray();
        var stack = new LinkedList<Integer>();
        for (int k = 0; k < nums.length; k++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[k]) {
                result[stack.pop()] = nums[k];
            }
            stack.push(k);
        }
        for (int k = 0; k < nums.length; k++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[k]) {
                result[stack.pop()] = nums[k];
            }
        }
        return result;
    }
}
