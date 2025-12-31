class Solution {
    public int maxProfit(int[] p) {
        int n = p.length;

        int dp[][] = new int[n][2];
            for(int arr[] : dp)
                Arrays.fill(arr, -1);

        return f(dp, p, 0, 1);
    }
    int f(int dp[][], int p[], int i, int buy){
        if(i >= p.length) return 0;

        if(dp[i][buy] != -1) return dp[i][buy];

        int profit = Integer.MIN_VALUE;

        if(buy == 1) profit = Math.max(
                        -p[i] + f(dp, p, i + 1, 0),
                        f(dp, p, i + 1, 1)
                    );
        else profit = Math.max(
            p[i] + f(dp, p, i + 2, 1),
            f(dp, p, i + 1, 0)
        );

        return dp[i][buy] = profit;
    }
}