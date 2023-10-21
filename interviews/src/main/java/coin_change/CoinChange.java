package coin_change;

import java.util.Arrays;

public class CoinChange {

    /**
     * O(N^2) space
     */
    public static int coinChange(int[] coins, int amount) {
        var m = coins.length;
        var dp = new int[m + 1][amount + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE - 1);
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 0;
            for (int j = 1; j < dp[0].length; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        return dp[m][amount] >= Integer.MAX_VALUE - 1 ? -1 : dp[m][amount];
    }

    /**
     * O(N) space
     */
    public static int coinChangeBestSpace(int[] coins, int amount) {
        var dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
                }
            }
        }
        return dp[amount] >= Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }
}
