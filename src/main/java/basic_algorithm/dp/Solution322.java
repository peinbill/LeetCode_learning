package basic_algorithm.dp;

import java.util.Arrays;

/**
 * @Classname Solution322
 * @Description TODO
 * @Date 2020/12/25 20:40
 * @Created by laohuang
 */
public class Solution322 {
    public int coinChange(int[] coins, int amount) {

        int max = amount+1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] >= max ? -1 : dp[amount];
    }


}
