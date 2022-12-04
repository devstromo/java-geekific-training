package kadane;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KadanesAlgorithmTest {

    @Test
    public void testKadaneAlgorithm() {
        int[] numbers = new int[] { -2, -3, -5, 2, 2, -1, 4, -3 };
        assertEquals(7, KadanesAlgorithm.solve(numbers));
    }
}