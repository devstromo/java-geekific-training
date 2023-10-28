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
    public void testCoinChangeIIBest() {
        assertEquals(4, coinChangeII.changeBest(10, new int[]{2, 3, 5}));
    }


}