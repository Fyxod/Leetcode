class Solution {
    public int minDistance(String word1, String word2) {
        return word1.length() + word2.length() - 2 * longestCommonSubsequence(word1, word2);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int p = text1.length();
        int q = text2.length();
        int dp[] = new int[q + 1];

        for(int i = 1; i <= p; i++){
            int curr[] = new int[q + 1];
            for(int j = 1; j <= q; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) curr[j] = 1 + dp[j - 1];
                else curr[j] = Math.max(dp[j], curr[j - 1]);
            }
            dp = curr;
        }
        return dp[q];
    }
}