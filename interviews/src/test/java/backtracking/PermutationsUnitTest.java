package backtracking;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

class PermutationsUnitTest {

    Permutations permutations = new Permutations();

    @Test
    public void testPermute() {
        int[] nums = {1, 2, 3};

        List<List<Integer>> actual = permutations.permute(nums);

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 2, 3));
        expected.add(Arrays.asList(1, 3, 2));
        expected.add(Arrays.asList(2, 1, 3));
        expected.add(Arrays.asList(2, 3, 1));
        expected.add(Arrays.asList(3, 1, 2));
        expected.add(Arrays.asList(3, 2, 1));

        assertThat(actual, containsInAnyOrder(expected.toArray()));
    }
}