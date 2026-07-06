class Solution {
    int grid[][];
    int dp[];
    int m, n;
    int INF = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        dp = new int[n];
        dp[n - 1] = grid[m - 1][n - 1];
        for(int i = n - 2; i >= 0; i--) dp[i] = grid[m - 1][i] + dp[i + 1];

        for(int i = m - 2; i >= 0; i--){
            int curr[] = new int[n];
            curr[n - 1] = grid[i][n - 1] + dp[n - 1];
            for(int j = n - 2; j >= 0; j--){
                curr[j] = grid[i][j] + Math.min(curr[j + 1], dp[j]);
            }
            dp = curr;
        }
        return dp[0];
    }
}