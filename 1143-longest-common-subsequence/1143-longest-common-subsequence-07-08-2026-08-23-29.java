class Solution {
    int n1, n2;
    int dp[];
    char[] s1, s2;
    public int longestCommonSubsequence(String text1, String text2) {
        s1 = text1.toCharArray();
        s2 = text2.toCharArray();
        n1 = text1.length();
        n2 = text2.length();

        dp = new int[n2 + 1];
        int curr[] = new int[n2 + 1];

        for(int i = n1 - 1; i >= 0; i--){
            for(int j = n2 - 1; j >= 0; j--){
                if(s1[i] == s2[j]) curr[j] = 1 + dp[j + 1];
                else curr[j] = Math.max(dp[j], curr[j + 1]);
            }
            int temp[] = dp;
            dp = curr;
            curr = temp;
        }

        return dp[0];
    }
}