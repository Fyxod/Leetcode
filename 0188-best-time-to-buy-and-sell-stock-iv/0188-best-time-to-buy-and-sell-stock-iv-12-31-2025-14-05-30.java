class Solution {
    public int maxProfit(int k, int[] p) {
        int n = p.length;

        int dp[][][] = new int[n][2][k];
        for (int arr[][] : dp)
            for(int arr2[] : arr) Arrays.fill(arr2, -1);
        return f(p, dp, 0, 1, 0, k);
    }

    int f(int p[], int dp[][][], int i, int buy, int lim, int k){
        if(i == p.length || lim == k) return 0;

        if(dp[i][buy][lim] != -1) return dp[i][buy][lim];

        if(buy == 1) return dp[i][buy][lim] = Math.max(
            -p[i] + f(p, dp, i + 1, 0, lim, k),
            f(p, dp, i + 1, 1, lim, k)
        );
        else return dp[i][buy][lim] = Math.max(
            p[i] + f(p, dp, i + 1, 1, lim + 1, k),
            f(p, dp, i + 1, 0, lim, k)
        );
    }
}