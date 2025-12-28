class Solution {
    public int minDistance(String word1, String word2) {
        return word1.length() + word2.length() - 2 * longestCommonSubsequence(word1, word2);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int p = text1.length();
        int q = text2.length();
        int dp[][] = new int[p + 1][q + 1];

        for(int arr[] : dp) Arrays.fill(arr, -1);
        return f(text1, text2, p - 1, q - 1, dp);
    }
    int f(String t1, String t2, int p, int q, int dp[][]){
        if(p < 0 || q < 0) return 0;

        if(dp[p][q] != -1) return dp[p][q];

        if(t1.charAt(p) == t2.charAt(q)) dp[p][q] = 1 + f(t1, t2, p - 1, q - 1, dp);
        else dp[p][q] = Math.max(f(t1, t2, p - 1, q, dp), f(t1, t2, p, q - 1, dp));
        return dp[p][q];
    }
}