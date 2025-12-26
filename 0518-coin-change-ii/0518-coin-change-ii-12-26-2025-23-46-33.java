class Solution {
    public int change(int amount, int[] coins) {
        if(amount == 0) return 1;
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];
        for(int arr[] : dp) arr[0] = 1;
        dp[0][coins[0]] = 1;

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= amount; j++){
                if(coins[i] <= j) dp[i][j] = dp[i][j - coins[i]];
                dp[i][j] += dp[i - 1][j];
            }
        }
        return dp[n - 1][amount];
    }
}