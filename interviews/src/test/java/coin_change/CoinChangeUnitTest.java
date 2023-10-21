package coin_change;

import org.junit.jupiter.api.Test;

import static coin_change.CoinChange.coinChange;
import static coin_change.CoinChange.coinChangeBestSpace;
import static org.junit.jupiter.api.Assertions.*;

class CoinChangeUnitTest {

    @Test
    public void testCoinChange() {
        assertEquals(2, coinChange(new int[]{1, 2, 4, 5}, 7));
    }

    @Test
    public void testCoinChange2() {
        assertEquals(2, coinChangeBestSpace(new int[]{1, 2, 4, 5}, 7));
    }


}