class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        p = p.replaceAll("\\*+", "*");
        int n = p.length();

        int dp[][] = new int[m][n];

        return f(dp, s, p, m - 1, n - 1);
    }
    boolean f(int dp[][], String s, String p, int i, int j){
        if(i < 0){
            if(j < 0 || (j == 0 && p.charAt(j) == '*')) return true;
            return false;
        }
        if(j < 0) return false;

        if(dp[i][j] != 0) return dp[i][j] == 1;

        char ch1 = s.charAt(i);
        char ch2 = p.charAt(j);

        if(ch2 == '?' || ch1 == ch2) dp[i][j] = f(dp, s, p, i - 1, j - 1) ? 1 : -1;
        else if(ch2 == '*') dp[i][j] = (
            f(dp, s, p, i - 1, j - 1) ||
            f(dp, s, p, i - 1, j) ||
            f(dp, s, p, i, j - 1)
        ) ? 1 : -1;
        else dp[i][j] = -1;

        return dp[i][j] == 1;
    }
}