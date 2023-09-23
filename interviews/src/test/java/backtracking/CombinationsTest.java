package backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

class CombinationsTest {

    Combinations combinationsObj = new Combinations();

    @Test
    public void testCombine() {
        int n = 4, k = 2;

        List<List<Integer>> actual = combinationsObj.combine(n, k);

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 2));
        expected.add(Arrays.asList(1, 3));
        expected.add(Arrays.asList(1, 4));
        expected.add(Arrays.asList(2, 3));
        expected.add(Arrays.asList(2, 4));
        expected.add(Arrays.asList(3, 4));

        assertThat(actual, containsInAnyOrder(expected.toArray()));
    }

}