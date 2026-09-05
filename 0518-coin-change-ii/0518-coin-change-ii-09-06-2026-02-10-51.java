class Solution {
    int coins[];
    int dp[][];
    public int change(int amount, int[] coins) {
        this.coins = coins;
        int n = coins.length;

        dp = new int[n][amount + 1];
        for(int arr[] : dp) Arrays.fill(arr, -1);

        return f(0, amount);
    }
    int f(int i, int total){
        if(total == 0) return 1;
        if(total <= 0 || i == coins.length) return 0;

        if(dp[i][total] != -1) return dp[i][total];
        return dp[i][total] = f(i, total - coins[i]) + f(i + 1, total);
    }
}