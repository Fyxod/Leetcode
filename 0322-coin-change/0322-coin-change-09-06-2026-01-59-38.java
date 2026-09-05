class Solution {
    int INF = Integer.MAX_VALUE / 2;
    int coins[];
    int dp[];
    public int coinChange(int[] coins, int target) {
        int n = coins.length;
        this.coins = coins;

        dp = new int[target + 1];

        for(int amount = 1; amount <= target; amount++){
            int min = INF;
            for(int a : coins){
                if(a <= amount){
                    min = Math.min(min, dp[amount - a]);
                }
            }

            dp[amount] = min + 1;
        }

        int ans = dp[target];
        return ans >= INF ? -1 : ans;
    }
}