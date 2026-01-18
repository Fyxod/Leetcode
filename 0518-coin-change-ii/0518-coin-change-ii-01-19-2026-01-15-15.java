class Solution {
    int n;
    int dp[];
    public int change(int amount, int[] coins) {
        n = coins.length;
        dp = new int[amount + 1];
        dp[0] = 1;

        for(int i = n - 1; i >= 0; i--){
            for(int sum = 0; sum <= amount; sum++){
                int ways = dp[sum];
                if(sum - coins[i] >= 0) ways += dp[sum - coins[i]];
                dp[sum] = ways;
            }
        }

        return dp[amount];
    }
}