class Solution {
    int dp[][];
    int m, n;
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        dp = new int[m][n];
        for(int i = 0; i < n; i++) dp[m - 1][i] = 1;
        for(int i = 0; i < m; i++) dp[i][n - 1] = 1;

        for(int r = m - 2; r >= 0; r--){
            for(int c = n - 2; c >= 0; c--){
                dp[r][c] = dp[r + 1][c] + dp[r][c + 1];
            }
        }
        return dp[0][0];
    }
    int f(int r, int c){
        if(r == m - 1 && c == n - 1) return 1;
        if(r >= m || c >= n) return 0;

        if(dp[r][c] != -1) return dp[r][c];
        return dp[r][c] = f(r + 1, c) + f(r, c + 1); 
    }
}