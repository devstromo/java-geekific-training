package coin_change;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangeIIUnitTest {

    private final CoinChangeII coinChangeII = new CoinChangeII();

    @Test
    public void testCoinChangeII() {
        assertEquals(4, coinChangeII.change(10, new int[]{2, 3, 5}));
    }

    @Test
    public void testCoinChangeIIImprovement() {
        assertEquals(4, coinChangeII.changeImprovement(10, new int[]{2, 3, 5}));
    }
    @Test
    public void testCoinChangeIILinear() {
        assertEquals(4, coinChangeII.changeBestLinear(10, new int[]{2, 3, 5}));
    }

}