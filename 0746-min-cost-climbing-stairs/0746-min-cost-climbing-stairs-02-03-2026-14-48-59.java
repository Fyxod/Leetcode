class Solution {
    int[] dp, cost;
    int n;
    public int minCostClimbingStairs(int[] c) {
        cost = c;
        n = cost.length;
        dp = new int[n];
        Arrays.fill(dp, -1);

        return Math.min(f(0), f(1));
    }
    int f(int i){
        if(i == n) return 0;
        if(i > n) return Integer.MAX_VALUE / 2;

        if(dp[i] != -1) return dp[i];

        return dp[i] = cost[i] + Math.min(f(i + 1), f(i + 2));
    }
}