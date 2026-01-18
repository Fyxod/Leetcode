class Solution {
    int n;
    int dp[][];
    int INF = Integer.MAX_VALUE / 2;
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        n = coins.length;
        dp = new int[n][amount + 1];
        for(int arr[] : dp) Arrays.fill(arr, -1);
        int res = f(0, amount, coins);
        return res >= INF ? -1 : res;
    }
    int f(int i, int sum, int coins[]){
        if(sum < 0) return INF;
        if(i == n) return sum == 0 ? 0 : INF;

        if(dp[i][sum] != -1) return dp[i][sum];

        return dp[i][sum] = Math.min(
            f(i + 1, sum, coins),
            1 + f(i, sum - coins[i], coins)
        );
    }
}