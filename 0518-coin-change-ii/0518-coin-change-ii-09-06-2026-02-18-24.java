class Solution {
    int coins[];
    int dp[];
    public int change(int amount, int[] coins) {
        this.coins = coins;
        int n = coins.length;

        dp = new int[amount + 1];
        dp[0] = 1;

        for(int i = n - 1; i >= 0; i--){
            int curr[] = new int[amount + 1];
            curr[0] = 1;
            for(int total = 1; total <= amount; total++){
                curr[total] = dp[total];
                if(total - coins[i] >= 0) curr[total] += curr[total - coins[i]];
            }
            int temp[] = curr;
            curr = dp;
            dp = temp;
        }

        return dp[amount];
    }
}