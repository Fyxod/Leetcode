class Solution {
    int coins[];
    int amount;
    int n;
    int dp[][];
    public int change(int amount, int[] coins) {
        this.amount = amount;
        this.coins = coins;
        n = coins.length;

        dp = new int[n][amount + 1];
        for(int arr[] : dp) Arrays.fill(arr, -1);

        return f(0, amount);
    }
    int f(int i, int sum){
        if(sum == 0)  return 1;
        if(sum < 0 || i == n) return 0;

        if(dp[i][sum] != -1) return dp[i][sum];

        dp[i][sum] = f(i + 1, sum);
        if(sum - coins[i] >= 0) dp[i][sum] += f(i, sum - coins[i]);

        return dp[i][sum];
    }
}