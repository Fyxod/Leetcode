class Solution {
    int coins[];
    int dp[][];
    public int change(int amount, int[] coins) {
        this.coins = coins;
        int n = coins.length;

        dp = new int[n + 1][amount + 1];
        for(int arr[] : dp) arr[0] = 1;

        for(int i = n - 1; i >= 0; i--){
            for(int total = 1; total <= amount; total++){
                dp[i][total] = dp[i + 1][total];
                if(total - coins[i] >= 0) dp[i][total] += dp[i][total - coins[i]];
            }
        }

        return dp[0][amount];
    }
}