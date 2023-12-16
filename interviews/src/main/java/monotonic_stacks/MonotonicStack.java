package monotonic_stacks;

import java.util.LinkedList;

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
}
