class Solution {
    int n;
    int dp[][][];
    int INF = Integer.MAX_VALUE;
    public int maxProfit(int[] prices) {
        n = prices.length;
        dp = new int[n][2][2];
        for(int a[][] : dp) for(int arr[] : a) Arrays.fill(arr, -1);
        return f(prices, 0, 0, 0);
    }
    int f(int prices[], int day, int hold, int cnt){
        if(cnt == 2 || day == n){
            return 0;
        }

        if(dp[day][hold][cnt] != -1) return dp[day][hold][cnt];
        int res = INF;
        if(hold == 1){
            res = Math.max(
                prices[day] + f(prices, day + 1, 0, cnt + 1),
                f(prices, day + 1, 1, cnt)
            );
        }
        else{
            res = Math.max(
                -prices[day] + f(prices, day + 1, 1, cnt),
                f(prices, day + 1, 0, cnt)
            );
        }

        return dp[day][hold][cnt] = res;
    }
}