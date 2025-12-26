class Solution {
    public int change(int amount, int[] coins) {
        if(amount == 0) return 1;
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];
        for(int arr[] : dp) Arrays.fill(arr, -1);
        return f(coins, dp, n, amount, 0);
    }
    int f(int coins[], int dp[][], int n, int t, int start){
        if(t == 0) return 1;
        if(t < 0) return 0;

        if(dp[start][t] != -1) return dp[start][t];

        int c = 0;
        for(int i = start; i < n; i++){
            c += f(coins, dp, n, t - coins[i], i);
        }
        return dp[start][t] = c;
    }
}