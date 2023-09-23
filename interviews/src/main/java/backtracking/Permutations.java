package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        var permutations = new ArrayList<List<Integer>>();
        backtrack(permutations, new ArrayList<>(), nums);
        return permutations;
    }

    public void backtrack(List<List<Integer>> permutations, List<Integer> currentPerm, int[] nums) {
        if (currentPerm.size() == nums.length) {
            permutations.add(new ArrayList<>(currentPerm));
            return;
        }
        for (var num : nums) {
            if (currentPerm.contains(num))
                continue;
            currentPerm.add(num);
            backtrack(permutations, currentPerm, nums);
            currentPerm.remove(currentPerm.size() - 1);
        }
    }
}
