class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];
        for(int arr[] : dp) Arrays.fill(arr, -1);
        int res = f(coins, dp, amount, n);
        return res > 100000 ? -1 : res;
    }
    int f(int coins[], int dp[][], int t, int n){
        if(t <= 0) return 0;
        int min = Integer.MAX_VALUE / 2;
        for(int i = 0; i < n; i++){
            if(dp[i][t] != -1) min = Math.min(min, dp[i][t]);
            else if(coins[i] <= t) min = Math.min(min, dp[i][t] = 1 + f(coins, dp, t - coins[i], n));
        }

        return min;
    }
}