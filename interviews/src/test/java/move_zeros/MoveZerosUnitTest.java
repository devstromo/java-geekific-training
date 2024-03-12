package move_zeros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveZerosUnitTest {
    private final MoveZeros moveZeros = new MoveZeros();

    @Test
    public void testMoveZero() {
        var input = new int[]{3, 0, 6, 7, 8, 9, 0, 0, 2, 0};
        var expected = new int[]{3, 6, 7, 8, 9, 2, 0, 0, 0, 0};
        assertArrayEquals(expected, MoveZeros.moveZerosBruteForce(input));
    }
}