package longest_substring_without_repeating;

import static java.lang.Math.max;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String input) {
        var max = 0;
        var left = 0;
        var right = 0;

        var chars = new HashSet<Character>();
        while (right < input.length()) {
            var c = input.charAt(right);
            if (chars.contains(c)) {
                chars.remove(input.charAt(right));
                left++;
            } else {
                chars.add(c);
                max = max(max, chars.size());
                right++;
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstringMap(String input) {
        var max = 0;
        var left = 0;
        var right = 0;

        var chars = new HashMap<Character, Integer>();
        while (right < input.length()) {
            var c = input.charAt(right);
            if (chars.containsKey(c)) {
                max = max(max, right - left);
                left = max(left, chars.get(c) + 1);
            }
            chars.put(c, right);
            right++;
        }
        return max(max, right - left);
    }

}
