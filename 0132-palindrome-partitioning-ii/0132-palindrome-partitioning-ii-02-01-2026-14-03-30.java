class Solution {
    boolean isPal[][];
    int n;
    int dp[];
    int INF = Integer.MAX_VALUE / 2;
    public int minCut(String s) {
        n = s.length();
        isPal = new boolean[n][n];

        for(int i = n - 1; i >= 0; i--){
            for(int j = n - 1; j >= i; j--){
                if(s.charAt(i) == s.charAt(j)) isPal[i][j] = (j - i < 2 || isPal[i + 1][j - 1]);
            }
        }

        dp = new int[n];
        Arrays.fill(dp, -1);

        return f(s, 0);
    }
    int f(String s, int i){
        if(i == n) return -1;

        if(dp[i] != -1) return dp[i];

        int min = INF;
        for(int k = i; k < n; k++){
            if(isPal[i][k]) min = Math.min(min, f(s, k + 1));
        }

        return dp[i] = min + 1;
    }
}