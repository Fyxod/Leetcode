class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        for(int a : prices) max = Math.max(max, a);
        int dp[][] = new int[n][max + 1];
        for(int arr[] : dp) Arrays.fill(arr, -1);

        return f(prices, dp, -1, n - 1);
    }
    int f(int prices[], int dp[][], int max, int i){
        if(i < 0) return 0;
        if(max < 0) max = prices[i];

        if(dp[i][max] != -1) return dp[i][max];

        int ans = 0;
        if(max > prices[i]) {
            ans = max - prices[i] + f(prices, dp, -1, i - 1);
            ans = Math.max(ans, max - prices[i] + f(prices, dp, prices[i], i - 1));
        }
        ans = Math.max(ans, f(prices, dp, max, i - 1));
        ans = Math.max(ans, f(prices, dp, -1, i - 1));

        return dp[i][max] = ans;
    }
}