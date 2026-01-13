class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int arr[] : dp) Arrays.fill(arr, -1);

        return f(dp, m, n, 0, 0);
    }
    int f(int dp[][], int m, int n, int i, int j){
        if(i == m - 1 && j == n - 1) return 1;
        if(i >= m || j >= n) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = f(dp, m, n, i + 1, j) + f(dp, m, n, i, j + 1); 
    }
}