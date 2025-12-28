class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];

        for(int arr[] : dp) Arrays.fill(arr, -1);
        return n - f(dp, s, 0, n - 1);
    }
    int f(int dp[][], String s, int l, int r){
        if(l == r) return 1;
        if(l > r) return 0;
        
        if(dp[l][r] != -1) return dp[l][r];
        if(s.charAt(l) == s.charAt(r)) return dp[l][r] = 2 + f(dp, s, l + 1, r - 1);
        return dp[l][r] = Math.max(f(dp, s, l + 1, r), f(dp, s, l, r - 1));
    }
}