class Solution {
    int INF = Integer.MAX_VALUE / 2;
    int coins[];
    int amount;
    int n;
    int dp[];
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.amount = amount;

        n = coins.length;
        dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        int res = f(0);
        return res >= INF ? -1 : res;
    }
    int f(int sum){
        if(sum == amount) return 0;
        if(sum > amount) return INF;

        if(dp[sum] != -1) return dp[sum];

        int min = INF;
        for(int coin : coins){
            if(sum <= amount - coin) min = Math.min(min, f(sum + coin));
        }

        return dp[sum] = 1 + min;
    }
}