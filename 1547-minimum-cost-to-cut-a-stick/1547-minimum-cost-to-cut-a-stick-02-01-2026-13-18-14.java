class Solution {
    int n;
    int dp[][];
    int cuts[];
    int INF = Integer.MAX_VALUE / 2;
    public int minCost(int l, int[] c) {
        Arrays.sort(c);
        int len = l;
        n = c.length;
        cuts = new int[n + 2];
        cuts[n + 1] = len;
        for(int i = 1; i <= n; i++) cuts[i] = c[i - 1];
        dp = new int[n + 2][n + 2];
        for(int arr[] : dp) Arrays.fill(arr, -1);

        return f(0, n + 1);
    }
    int f(int i, int j){
        if(j - i < 2) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int min = INF;
        for(int k = i + 1; k < j; k++){
            min = Math.min(min, cuts[j] - cuts[i] + f(i, k) + f(k, j));
        }

        return dp[i][j] = min;
    }
}