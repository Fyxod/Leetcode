class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid[0][0] == 1) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int dp[] = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            if(grid[0][i] != 1) dp[i] = dp[i - 1];
        }

        for(int i = 1; i < m; i++){
            int curr[] = new int[n];
            if(grid[i][0] != 1) curr[0] = dp[0];
            for(int j = 1; j < n; j++){
                if(grid[i][j] != 1) curr[j] = dp[j] + curr[j - 1];
            }
            dp = curr;
        }
        return dp[n - 1];
    }
}