class Solution {
    public int cherryPickup(int[][] grid) {
        int dir[] = {-1, 0, 1};
        int m = grid.length;
        int n = grid[0].length;

        int dp[][][] = new int[m][n][n];
        
        for(int arr[][] : dp) for(int arr2[] : arr) Arrays.fill(arr2, -1);

        return f(dp, grid, 0, 0, n - 1, m, n, dir);
    }

    int f(int dp[][][], int grid[][], int i, int j1, int j2, int m, int n, int dir[]){
        if(j1 < 0 || j2 < 0 || j1 > n - 1 || j2 > n - 1) return -(int) 1e6;
        if(i == m - 1){
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        
        int max = Integer.MIN_VALUE;
        for(int a = 0; a < 3; a++){
            for(int b = 0; b < 3; b++){
                max = Math.max(max, f(dp, grid, i + 1, j1 + dir[a], j2 + dir[b], m, n, dir));
            }
        }
        if(j1 == j2) return dp[i][j1][j2] = grid[i][j1] + max;
        else return dp[i][j1][j2] = grid[i][j1] + grid[i][j2] + max;
    }
}