class Solution {
    int n;
    int dp[][];
    int coins[];
    public int coinChange(int[] c, int amount) {
        n = c.length;
        dp = new int[amount + 1][n];
        for(int arr[] : dp) Arrays.fill(arr, -1);
        coins = c;
        int res = f(amount, 0);
        return res > Integer.MAX_VALUE / 3 ? -1 : res;
    }
    int f(int amount, int ind){
        if(amount == 0) return 0;
        if(ind >= n || amount < 0) return Integer.MAX_VALUE / 2;

        if(dp[amount][ind] != -1) return dp[amount][ind];
        return dp[amount][ind] = Math.min(
            1 + f(amount - coins[ind], ind),
            f(amount, ind + 1)
        );
    }
}