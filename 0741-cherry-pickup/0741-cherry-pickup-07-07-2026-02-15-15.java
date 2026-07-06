class Solution {
    int n;
    int dp[][][];
    int moves[][] = {{0, 1, 1}, {0, 1, 0}, {1, 0, 1}, {1, 0, 0}};
    int grid[][];
    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        n = grid[0].length;
        if(grid[0][0] == -1 || grid[n - 1][n - 1] == -1) return 0;
        dp = new int[n][n][n];

        for(int arr[][] : dp) for(int arr2[] : arr) Arrays.fill(arr2, -1);
        int res = helper(0, 0, 0);
        return res >= 0 ? res : 0;
    }
    int helper(int r1, int c1, int r2){
        int c2 = r1 + c1 - r2;
        if(r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 ||  grid[r2][c2] == -1) return Integer.MIN_VALUE / 2;
        if(r1 == n - 1 && c1 == n - 1) return grid[n - 1][n - 1];
        if(dp[r1][c1][r2] != -1) return dp[r1][c1][r2];

        int res = Integer.MIN_VALUE / 2;
        for(int move[] : moves){
            res = Math.max(res, helper(r1 + move[0], c1 + move[1], r2 + move[2]));
        }
        int cherry = r1 == r2 ? grid[r1][c1] : grid[r1][c1] + grid[r2][c2];
        return dp[r1][c1][r2] = res + cherry;
    }
}