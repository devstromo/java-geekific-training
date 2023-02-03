package intersection_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class IntersectionArrays {

    public static int[] intersectionWithSet(int[] nums1, int[] nums2) {
        var set = new HashSet<Integer>();
        for (int num : nums1) {
            set.add(num);
        }

        var result = new HashSet<Integer>();
        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }
        return result.stream()
          .mapToInt(Integer::intValue)
          .toArray();
    }

    // works better on sets
    public static int[] intersectionWithRetainAll(int[] nums1, int[] nums2) {
        var set1 = Arrays.stream(nums1)
          .boxed()
          .collect(Collectors.toSet());
        var set2 = Arrays.stream(nums2)
          .boxed()
          .collect(Collectors.toSet());
        set1.retainAll(set2);
        return set1.stream()
          .mapToInt(Integer::intValue)
          .toArray();
    }

    public static int[] intersectionWithMaps(int[] nums1, int[] nums2) {
        var map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        var result = new ArrayList<Integer>();
        for (int key : nums2) {
            if (map.containsKey(key) && map.get(key) > 0) {
                map.put(key, map.get(key) - 1);
                result.add(key);
            }
        }
        return result.stream()
          .mapToInt(Integer::intValue)
          .toArray();
    }
}
