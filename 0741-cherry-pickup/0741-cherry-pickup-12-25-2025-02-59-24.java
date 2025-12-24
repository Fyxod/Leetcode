class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;

        int dp[][][][] = new int[n][n][n][n];
        for(int arr[][][] : dp)
            for(int arr2[][] : arr)
                for(int arr3[] : arr2) Arrays.fill(arr3, -1);
        
        int res = f(grid, dp, n, n - 1, n - 1, n - 1, n - 1);
        return res < 0? 0 : res;
    }
    int f(int grid[][], int dp[][][][], int n, int i1, int j1, int i2, int j2){
        if(i1 < 0 || j1 < 0 || i2 < 0 || j2 < 0 || grid[i1][j1] == -1 || grid[i2][j2] == -1) return -(int)1e6;

        if(i1 == 0 && j1 == 0 && i2 == 0 && j2 == 0) return grid[0][0];
        if(dp[i1][j1][i2][j2] != -1) return dp[i1][j1][i2][j2];

        int max = -(int)1e6;
        int dir[][] = {{-1, 0}, {0, -1}};

        for(int p = 0; p < 2; p++){
            for(int q = 0; q < 2; q++){
                int na = i1 + dir[p][0];
                int nb = j1 + dir[p][1];
                int nc = i2 + dir[q][0];
                int nd = j2 + dir[q][1];

                max = Math.max(max, f(grid, dp, n, na, nb, nc, nd));
            }
        }
        if(i1 == i2 && j1 == j2) return dp[i1][j1][i2][j2] = max + grid[i1][j1];
        else return dp[i1][j1][i2][j2] = max + grid[i1][j1] + grid[i2][j2];
    }
}