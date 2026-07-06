class Solution {
    int m, n;
    int grid[][];
    int dp[][];
    public int uniquePathsWithObstacles(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        if(grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return 0;
        dp = new int[m][n];
        for(int i = m - 1; i >= 0 && grid[i][n - 1] == 0; i--) dp[i][n - 1] = 1;
        for(int i = n - 1; i >= 0 && grid[m - 1][i] == 0; i--) dp[m - 1][i] = 1;

        for(int i = m - 2; i>= 0; i--){
            for(int j = n - 2; j>= 0; j--){
                if(grid[i][j] == 1) continue;
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
}