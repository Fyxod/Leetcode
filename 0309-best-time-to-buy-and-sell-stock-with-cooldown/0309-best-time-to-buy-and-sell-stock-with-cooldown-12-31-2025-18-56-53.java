class Solution {
    public int maxProfit(int[] p) {
        int n = p.length;

        int dp[][][] = new int[n][2][2];
        for(int arr[][] : dp)
            for(int arr2[] : arr)
                Arrays.fill(arr2, -1);

        return f(dp, p, 0, 1, 0);
    }
    int f(int dp[][][], int p[], int i, int buy, int cool){
        if(i == p.length) return 0;

        if(dp[i][buy][cool] != -1) return dp[i][buy][cool];

        int profit = Integer.MIN_VALUE;

        if(buy == 1){
            if(cool == 1) profit = f(dp, p, i + 1, 1, 0);
            else profit = Math.max(
                -p[i] + f(dp, p, i + 1, 0, 0),
                f(dp, p, i + 1, 1, 0)
            );
        }
        else profit = Math.max(
            p[i] + f(dp, p, i + 1, 1, 1),
            f(dp, p, i + 1, 0, 0)
        );

        return dp[i][buy][cool] = profit;
    }
}