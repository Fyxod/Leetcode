class Solution {
    int n;
    int dp[][];
    public int change(int amount, int[] coins) {
        n = coins.length;
        dp = new int[n][amount + 1];
        for(int arr[] : dp) Arrays.fill(arr, -1);

        return f(0, amount, coins);
    }
    int f(int i, int sum, int coins[]){
        if(sum == 0) return 1;
        if(sum < 0 || i == n) return 0;

        if(dp[i][sum] != -1) return dp[i][sum];

        return dp[i][sum] = f(i, sum - coins[i], coins) + f(i + 1, sum, coins);
    }
}