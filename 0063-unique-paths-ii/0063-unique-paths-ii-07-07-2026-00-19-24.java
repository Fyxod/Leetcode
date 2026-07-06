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
        for(int arr[] : dp) Arrays.fill(arr, -1);

        return f(0, 0);
    }
    int f(int i, int j){
        if(i == m - 1 && j == n - 1) return 1;
        if(i >= m || j >= n || grid[i][j] == 1) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = f(i + 1, j) + f(i, j + 1);
    }
}