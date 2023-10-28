package coin_change;

import java.util.Arrays;

public class CoinChangeII {
    public int change(int amount, int[] coins) {
        var dp = new int[amount + 1][coins.length];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= amount; i++) {
            dp[i][0] = i < coins[0] ? 0 : dp[i - coins[0]][0];
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j < coins.length; j++) {
                dp[i][j] = i < coins[j] ? dp[i][j - 1] : dp[i][j - 1] + dp[i - coins[j]][j];
            }
        }
        return dp[amount][coins.length - 1];
    }

    public int changeBest(int amount, int[] coins) {
        var prev = new int[amount + 1];
        prev[0] = 1;
        for (int i = 1; i <= amount; i++) {
            prev[i] = i < coins[0] ? 0 : prev[i - coins[0]];
        }
        for (int j = 1; j < coins.length; j++) {
            var next = new int[amount + 1];
            next[0] = 1;
            for (int i = 1; i <= amount; i++) {
                next[i] = i < coins[j] ? prev[i] : prev[i] + next[i - coins[j]];
            }
            prev = next;
        }

        return prev[amount];
    }
}
