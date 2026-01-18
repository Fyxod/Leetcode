class Solution {
    int n;
    int dp[][];
    public int change(int amount, int[] coins) {
        n = coins.length;
        dp = new int[n + 1][amount + 1];
        for(int i = 0; i <= n; i++) dp[i][0] = 1;

        for(int i = n - 1; i >= 0; i--){
            for(int sum = 0; sum <= amount; sum++){
                int ways = dp[i + 1][sum];
                if(sum - coins[i] >= 0) ways += dp[i][sum - coins[i]];
                dp[i][sum] = ways;
            }
        }

        return dp[0][amount];
    }
}