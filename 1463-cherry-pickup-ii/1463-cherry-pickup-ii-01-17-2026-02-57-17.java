class Solution {
    int m;
    int n;
    int INF = Integer.MAX_VALUE / 2;
    public int cherryPickup(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int dp[][][] = new int[m][n][n];
        for(int arr[][] : dp) for(int arr2[] : arr) Arrays.fill(arr2, -1);

        return f(dp, grid, 0, 0, n - 1);
    }
    int f(int dp[][][], int grid[][], int i, int j1, int j2){
        if(i == m || j1 < 0 || j2 < 0 || j1 >= n || j2 >= n) return 0;

        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int max = 0;
        for(int p = -1; p <= 1; p++){
            for(int q = -1; q <= 1; q++){
                max = Math.max(max, f(dp, grid, i + 1, j1 + p, j2 + q));
            }
        }

        int picked;
        if(j1 == j2) picked = grid[i][j1];
        else picked = grid[i][j1] + grid[i][j2];

        return dp[i][j1][j2] = picked + max;
    }
}