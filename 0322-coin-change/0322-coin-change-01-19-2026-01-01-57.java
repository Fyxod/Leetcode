class Solution {
    int n;
    int dp[][];
    int INF = Integer.MAX_VALUE / 2;
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        n = coins.length;
        dp = new int[n + 1][amount + 1];
        Arrays.fill(dp[n], INF);
        for(int i = 0; i < n; i++){
            dp[i][0] = 0;
        }

        for(int i = n - 1; i >= 0; i--){
            for(int sum = 1; sum <= amount; sum++){
                int min = dp[i + 1][sum];
                if(sum - coins[i] >= 0) min = Math.min(min, 1 + dp[i][sum - coins[i]]);
                dp[i][sum] = min;
            }
        }

        return dp[0][amount] == INF ? -1 : dp[0][amount];
    }
}