class Solution {
    public int maxProfit(int k, int[] p) {
        int n = p.length;

        int dp[][][] = new int[n + 1][2][k + 1];

        for(int i = n - 1; i >= 0; i--){
            for(int buy = 0; buy < 2; buy++){
                for(int lim = 0; lim < k; lim++){
                    if(buy == 1) dp[i][buy][lim] = Math.max(-p[i] + dp[i + 1][0][lim], dp[i + 1][1][lim]);
                    else dp[i][buy][lim] = Math.max(p[i] + dp[i + 1][1][lim + 1], dp[i + 1][0][lim]);
                }
            }
        }
        
        return dp[0][1][0];
    }
}