class Solution {
    public int maxProfit(int[] p, int fee) {
        int n = p.length;
        int dp[][] = new int[n + 1][2];

        for(int i = n - 1; i >= 0; i--){
            dp[i][1] = Math.max(-p[i] + dp[i + 1][0], dp[i + 1][1]);
            dp[i][0] = Math.max(p[i] - fee + dp[i + 1][1], dp[i + 1][0]);
        }

        return dp[0][1];
    }
}