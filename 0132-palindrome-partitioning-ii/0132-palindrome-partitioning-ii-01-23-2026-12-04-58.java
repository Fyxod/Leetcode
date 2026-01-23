class Solution {
    int n;
    int dp[];
    boolean isPal[][];
    public int minCut(String s) {
        n = s.length();
        dp = new int[n];
        Arrays.fill(dp, -1);
        isPal = new boolean[n][n];
        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                isPal[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || isPal[i + 1][j - 1]);
            }
        }

        return f(s, 0);
    }
    int f(String s, int start){
        if(start == n) return -1;

        if(dp[start] != -1) return dp[start];

        int min = n + 1;
        for(int i = start; i < n; i++){
            if(isPal[start][i]){
                min = Math.min(min, f(s, i + 1));
            }
        }

        return dp[start] = 1 + min;
    }
}