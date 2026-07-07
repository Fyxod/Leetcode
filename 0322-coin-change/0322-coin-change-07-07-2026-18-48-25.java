class Solution {
    int INF = Integer.MAX_VALUE / 2;
    int coins[];
    int amount;
    int n;
    int dp[][];
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.amount = amount;

        n = coins.length;
        dp = new int[n][amount + 1];
        for(int arr[] : dp) Arrays.fill(arr, -1);

        int res = f(0, 0);
        return res >= INF ? -1 : res;
    }
    int f(int i, int sum){
        if(sum == amount) return 0;
        if(sum > amount) return INF;
        if(i == n) return INF;

        if(dp[i][sum] != -1) return dp[i][sum];

        dp[i][sum] = f(i + 1, sum);
        if(sum <= amount - coins[i]) dp[i][sum] = Math.min(dp[i][sum], 1 + f(i, sum + coins[i]));

        return dp[i][sum];
    }
}