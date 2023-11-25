package robber_problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionUnitTest {

    private final Solution solution = new Solution();

    @Test
    public void testRobberRecursion() {
        assertEquals(16, solution.robRecursion(new int[]{2, 7, 9, 3, 1, 5}));
    }
    @Test
    public void testRobberDPTabulation() {
        assertEquals(16, solution.robTabulation(new int[]{2, 7, 9, 3, 1, 5}));
    }

}