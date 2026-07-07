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
        
        for(int sum = amount - 1; sum >= 0; sum--){
            int min = INF;
            for(int coin : coins){
                if(sum <= amount - coin) min = Math.min(min, dp[sum + coin]);
            }

            dp[sum] = 1 + min;
        }

        int res = dp[0];
        return res >= INF ? -1 : res;
    }
}