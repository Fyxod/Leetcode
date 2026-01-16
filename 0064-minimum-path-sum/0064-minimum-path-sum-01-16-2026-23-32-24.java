class Solution {
    int m;
    int n;
    int dp[][];
    int INF = Integer.MAX_VALUE / 2;
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n];
        for(int arr[] : dp) Arrays.fill(arr, -1);

        return f(0, 0, grid);
    }
    int f(int i, int j, int grid[][]){
        if(i == m - 1 && j == n - 1) return grid[i][j];
        if(i >= m || j >= n) return INF;

        if(dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = grid[i][j] + Math.min(
            f(i, j + 1, grid),
            f(i + 1, j, grid)
        );
    }
}