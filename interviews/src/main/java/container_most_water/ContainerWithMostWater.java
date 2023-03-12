package container_most_water;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class ContainerWithMostWater {

    public static int maxArea(int[] heights) {
        var maxArea = 0;
        var left = 0;
        var right = heights.length - 1;
        while (left < right) {
            var localArea = (right - left) * min(heights[left], heights[right]);
            maxArea = max(maxArea, localArea);
            if (heights[left] < heights[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
}
