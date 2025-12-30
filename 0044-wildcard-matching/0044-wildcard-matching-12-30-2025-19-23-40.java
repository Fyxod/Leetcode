class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        p = p.replaceAll("\\*+", "*");
        int n = p.length();
        if(m == 0){
            if(n == 0) return true;
            else return n == 1 && p.charAt(0) == '*';
        }
        else if(n == 0) return false;

        boolean dp[][] = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        if(p.charAt(0) == '*') dp[0][1] = true;

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                char ch1 = s.charAt(i - 1);
                char ch2 = p.charAt(j - 1);

                if(ch2 == '?' || ch1 == ch2) dp[i][j] = dp[i - 1][j - 1];
                else if(ch2 == '*') dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                else dp[i][j] = false;
            }
        }

        return dp[m][n];
    }
}