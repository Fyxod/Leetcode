class Solution {
    public int longestPalindromeSubseq(String s) {
        int p = s.length();
        int dp[] = new int[p + 1];

        for(int i = 1; i <= p; i++){
            int curr[] = new int[p + 1];
            for(int j = 1; j <= p; j++){
                if(s.charAt(i - 1) == s.charAt(p - j)) curr[j] = 1 + dp[j - 1];
                else curr[j] = Math.max(dp[j], curr[j - 1]);
            }
            dp = curr;
        }
        return dp[p];
    }
}