class Solution {
    public int change(int amount, int[] coins) {
        if(amount == 0) return 1;
        int n = coins.length;
        int dp[] = new int[amount + 1];
        dp[0] = 1;

        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= amount; j++){
                if(coins[i - 1] <= j) dp[j] += dp[j - coins[i - 1]];
            }
        }
        return dp[amount];
    }
}