class Solution {
    int dp[][];
    int m;
    int n;
    public int uniquePathsWithObstacles(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        dp = new int[m][n];
        for(int arr[] : dp) Arrays.fill(arr, -1);

        return f(0, 0, grid);
    }
    int f(int i, int j, int[][] grid){
        if(i >= m || j >= n || grid[i][j] == 1) return 0;
        if(i == m - 1 && j == n - 1) return 1;

        if(dp[i][j] != -1) return dp[i][j];
        int res = 0;
        res = f(i + 1, j, grid) + f(i, j + 1, grid);

        return dp[i][j] = res;
    }
}