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
        for(int arr[] : dp) Arrays.fill(arr, -1);

        return f(0, 0);
    }
    int f(int i, int j){
        if(i == m - 1 && j == n - 1) return grid[i][j];
        if(i >= m || j >= n) return INF;

        if(dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = grid[i][j] + Math.min(f(i + 1, j), f(i, j + 1));
    }
}