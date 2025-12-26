class Solution {
    public int change(int amount, int[] coins) {
        if(amount == 0) return 1;
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];
        for(int arr[] : dp) Arrays.fill(arr, -1);
        return f(coins, dp, amount, n - 1);
    }
    int f(int coins[], int dp[][], int t, int start){
        if(t == 0) return 1;
        if(start < 0 || t < 0) return 0;

        if(dp[start][t] != -1) return dp[start][t];

        return dp[start][t] = f(coins, dp, t - coins[start], start) + f(coins, dp, t, start - 1);
    }
}