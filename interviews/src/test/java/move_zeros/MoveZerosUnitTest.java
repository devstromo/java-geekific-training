package move_zeros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveZerosUnitTest {

    @Test
    public void testMoveZero() {
        var input = new int[]{3, 0, 6, 7, 8, 9, 0, 0, 2, 0};
        var expected = new int[]{3, 6, 7, 8, 9, 2, 0, 0, 0, 0};
        assertArrayEquals(expected, MoveZeros.moveZerosBruteForce(input));
    }

    @Test
    public void testMoveZero2() {
        var input = new int[]{3, 0, 6, 7, 8, 9, 0, 0, 2, 0};
        var expected = new int[]{3, 6, 7, 8, 9, 2, 0, 0, 0, 0};
        assertArrayEquals(expected, MoveZeros.moveZerosLinear(input));
    }

    @Test
    public void testMoveZero3() {
        var input = new int[]{3, 0, 6, 7, 8, 9, 0, 0, 2, 0};
        var expected = new int[]{3, 6, 7, 8, 9, 2, 0, 0, 0, 0};
        assertArrayEquals(expected, MoveZeros.moveZerosLinearInPlace(input));
    }
}