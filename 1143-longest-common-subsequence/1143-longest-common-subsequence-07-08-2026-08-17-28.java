class Solution {
    int n1, n2;
    int dp[][];
    char[] s1, s2;
    public int longestCommonSubsequence(String text1, String text2) {
        s1 = text1.toCharArray();
        s2 = text2.toCharArray();
        n1 = text1.length();
        n2 = text2.length();

        dp = new int[n1 + 1][n2 + 1];
        for(int i = n1 - 1; i >= 0; i--){
            for(int j = n2 - 1; j >= 0; j--){
                if(s1[i] == s2[j]) dp[i][j] = 1 + dp[i + 1][j + 1];
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }

        return dp[0][0];
    }
}