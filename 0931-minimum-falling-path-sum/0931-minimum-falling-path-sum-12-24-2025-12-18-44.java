class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int dp[] = new int[n];
        for(int i = 0; i < n; i++) dp[i] = grid[0][i];

        for(int i = 1; i < n; i++){
            int curr[] = new int[n];
            for(int j = 0; j < n; j++){
                int min = Integer.MAX_VALUE / 2;
                if(j > 0) min = Math.min(min, dp[j - 1]);
                min = Math.min(min, dp[j]);
                if(j < n - 1) min = Math.min(min, dp[j + 1]);
                curr[j] = grid[i][j] + min;
            }
            dp = curr;
        }
        int min = Integer.MAX_VALUE / 2;
        for(int i = 0; i < n; i++) min = Math.min(min, dp[i]);
        return min;
    }
}