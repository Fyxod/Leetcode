class Solution {
    int grid[][];
    int dp[][];
    int m, n;
    int INF = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n];
        dp[m - 1][n - 1] = grid[m - 1][n - 1];
        for(int i = m - 2; i >= 0; i--) dp[i][n - 1] = grid[i][n - 1] + dp[i + 1][n - 1];
        for(int i = n - 2; i >= 0; i--) dp[m - 1][i] = grid[m - 1][i] + dp[m - 1][i + 1];

        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                dp[i][j] = grid[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        return dp[0][0];
    }
}