class Solution {
    int m;
    int n;
    int INF = Integer.MAX_VALUE / 2;
    public int cherryPickup(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int dp[][] = new int[n][n];
        for(int arr[] : dp) Arrays.fill(arr, -INF);
        dp[0][n - 1] = grid[0][0] + grid[0][n - 1];
        for(int i = 1; i < m; i++){
            int curr[][] = new int[n][n];
            for(int arr[] : curr) Arrays.fill(arr, -INF);
            for(int j1 = 0; j1 < n; j1++){
                for(int j2 = 0; j2 < n; j2++){

                    int max = -INF;
                    for(int p = -1; p <= 1; p++){
                        for(int q = -1; q <= 1; q++){
                            int nj1 = j1 + p;
                            int nj2 = j2 + q;
                            if(nj1 >= 0 && nj2 >= 0 && nj1 < n && nj2 < n) max = Math.max(max, dp[nj1][nj2]);
                        }
                    }
                    if(max == -INF) continue;
                    int picked;
                    if(j1 == j2) picked = grid[i][j1];
                    else picked = grid[i][j1] + grid[i][j2];

                    curr[j1][j2] = picked + max;
                }
            } 
            dp = curr;
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}