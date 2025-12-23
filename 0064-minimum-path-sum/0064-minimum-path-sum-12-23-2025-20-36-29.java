class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int dp[] = new int[n];
        dp[0] = grid[0][0];
        for(int i = 1; i < n; i++) dp[i] = dp[i - 1] + grid[0][i];

        for(int i = 1; i < m; i++){
            int curr[] = new int[n];
            curr[0] = dp[0] + grid[i][0];
            for(int j = 1; j < n; j++){
                curr[j] = grid[i][j] + Math.min(dp[j], curr[j - 1]);
            }
            dp = curr;
        }

        return dp[n - 1];
    }
}