class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int p = text1.length();
        int q = text2.length();
        int dp[][] = new int[p + 1][q + 1];

        for(int i = 1; i <= p; i++){
            for(int j = 1; j <= q; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[p][q];
    }
}