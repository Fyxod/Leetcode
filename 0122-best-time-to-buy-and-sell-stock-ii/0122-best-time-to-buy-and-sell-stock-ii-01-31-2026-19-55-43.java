class Solution {
    int n;
    int dp[][];
    int INF = Integer.MAX_VALUE;
    public int maxProfit(int[] prices) {
        n = prices.length;
        dp = new int[n][2];
        for(int arr[] : dp) Arrays.fill(arr, -1);
        return f(prices, 0, 0);
    }
    int f(int prices[], int day, int hold){
        if(day == n){
            return 0;
        }

        if(dp[day][hold] != -1) return dp[day][hold];
        int res = INF;
        if(hold == 1){
            res = Math.max(
                prices[day] + f(prices, day + 1, 0),
                f(prices, day + 1, 1)
            );
        }
        else{
            res = Math.max(
                -prices[day] + f(prices, day + 1, 1),
                f(prices, day + 1, 0)
            );
        }

        return dp[day][hold] = res;
    }
}