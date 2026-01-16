class Solution {
    int INF = Integer.MAX_VALUE / 2;
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;

        int dp[][] = new int[n][n];
        for(int arr[] : dp) Arrays.fill(arr, INF);

        int min = INF;
        for(int i = 0; i < n; i++){
            min = Math.min(min, f(dp, grid, n, 0, i));
        }

        return min;
    }
    int f(int dp[][], int grid[][], int n, int i, int j){
        if(i >= n || j >= n || i < 0 || j < 0) return INF;
        if(i == n - 1) return grid[n - 1][j];

        if(dp[i][j] != INF) return dp[i][j];

        return dp[i][j] = grid[i][j] + Math.min(
            f(dp, grid, n, i + 1, j - 1),
            Math.min(
                f(dp, grid, n, i + 1, j + 1),
                f(dp, grid, n, i + 1, j)
            )
        );
    }
}