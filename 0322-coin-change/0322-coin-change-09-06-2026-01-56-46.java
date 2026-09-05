class Solution {
    int INF = Integer.MAX_VALUE / 2;
    int coins[];
    int dp[];
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        this.coins = coins;

        dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        int ans = f(amount);
        return ans >= INF ? -1 : ans;
    }
    int f(int amount){
        if(amount == 0) return 0;

        if(dp[amount] != -1) return dp[amount];
        int min = INF;
        for(int a : coins){
            if(a <= amount){
                min = Math.min(min, f(amount - a));
            }
        }

        return dp[amount] = min + 1;
    }
}