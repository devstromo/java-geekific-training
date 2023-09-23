package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        var combinations = new ArrayList<List<Integer>>();
        backtrack(combinations, new ArrayList<Integer>(), n, k, 1);
        return combinations;
    }

    private void backtrack(ArrayList<List<Integer>> combinations, ArrayList<Integer> currentComb, int n, int k, int start) {
        if (currentComb.size() == k) {
            combinations.add(new ArrayList<>(currentComb));
            return;
        }
        for (var currentElement = start; currentElement <= n; currentElement++) {
            currentComb.add(currentElement);
            backtrack(combinations, currentComb, n, k, currentElement + 1);
            currentComb.remove(currentComb.size() - 1);
        }
    }
}
