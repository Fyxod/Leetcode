class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int arr[] : dp) Arrays.fill(arr, -1);

        return f(dp, prices, 0, 1);
    }
    int f(int dp[][], int p[], int i, int buy){
        if(i == p.length) return 0;

        if(dp[i][buy] != -1) return dp[i][buy];

        if(buy == 1){
            return dp[i][buy] = Math.max(
                -p[i] + f(dp, p, i + 1, 0),
                f(dp, p, i + 1, 1)
            );
        }
        else return dp[i][buy] = Math.max(
            p[i] + f(dp, p, i + 1, 1),
            f(dp, p, i + 1, 0)
        );
    }
}