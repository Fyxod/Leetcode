class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, -1);
        int res = f(coins, dp, amount, n);
        return res > 100000 ? -1 : res;
    }
    int f(int coins[], int dp[], int t, int n){
        if(t == 0) return 0;
        if(dp[t] != -1) return dp[t]; 
        int min = Integer.MAX_VALUE / 2;

        for(int i = 0; i < n; i++){
            if(coins[i] <= t) min = Math.min(min, 1 + f(coins, dp, t - coins[i], n));
        }

        return dp[t] = min;
    }
}