class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[] = new int[amount + 1];
        dp[0] = 0;
        for(int t = 1; t <= amount; t++){
             int min = Integer.MAX_VALUE / 2;

            for(int j = 0; j < n; j++){
                if(coins[j] <= t) min = Math.min(min, 1 + dp[t - coins[j]]);
            }

            dp[t] = min;
        }
        return dp[amount] > 100000? -1 : dp[amount];
    }
}