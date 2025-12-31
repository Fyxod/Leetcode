class Solution {
    public int maxProfit(int[] p, int fee) {
        int n = p.length;
        int dp[] = new int[2];

        for(int i = n - 1; i >= 0; i--){
            int curr[] = new int[2];
            curr[1] = Math.max(-p[i] + dp[0], dp[1]);
            curr[0] = Math.max(p[i] - fee + dp[1], dp[0]);
            dp = curr;
        }

        return dp[1];
    }
}