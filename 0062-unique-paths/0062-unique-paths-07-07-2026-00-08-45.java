class Solution {
    int dp[][];
    int m, n;
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        dp = new int[m][n];
        for(int arr[] : dp) Arrays.fill(arr, -1);

        return f(0, 0);
    }
    int f(int r, int c){
        if(r == m - 1 && c == n - 1) return 1;
        if(r >= m || c >= n) return 0;

        if(dp[r][c] != -1) return dp[r][c];
        return dp[r][c] = f(r + 1, c) + f(r, c + 1); 
    }
}