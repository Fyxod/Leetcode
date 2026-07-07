class Solution {
    int coins[];
    int amount;
    int n;
    int dp[][];
    public int change(int amount, int[] coins) {
        if(amount == 0) return 1;
        this.amount = amount;
        this.coins = coins;
        n = coins.length;

        dp = new int[n + 1][amount + 1];
        for(int arr[] : dp) arr[0] = 1;
        for(int i = n - 1; i >= 0; i--){
            for(int sum = 0; sum <= amount; sum++){
                dp[i][sum] = dp[i + 1][sum];
                if(sum - coins[i] >= 0) dp[i][sum] += dp[i][sum - coins[i]];
            }
        }

        return dp[0][amount];
    }
}